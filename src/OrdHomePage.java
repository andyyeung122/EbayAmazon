import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import java.util.ArrayList;

public class OrdHomePage extends Scene{

    private GridPane grid;
    private Data data = new Data();
    private List<OrdItemsBox> itemList = new ArrayList<>();
    private Stage primaryStage;
    private String username;
    private String password;
    private EditProfile editProfile;

    private FriendsPage friendspage;
    private OrdTransactionHistory ordtranshist;
    private GuestHomePage guesthomepage;
    private NotificationsPage notificationspage;
    private OrdHomePage ordhomepage;



    public void setUsername(String username){
        this.username = username;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public OrdHomePage(){
        this("");
    }

    public OrdHomePage(String username) {
        super(new GridPane(),620,550);
        this.username=username;

        grid = (GridPane)this.getRoot();
        grid.setHgap(10);
        grid.setVgap(10);

        data.makeUserVip(username);
        if(data.isUserVip(username)) {
            data.makeUserVip(username);
            Text VIP = new Text("VIP");
            VIP.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
            VIP.setFill(Color.RED);
            grid.add(VIP, 1, 0, 2, 1);
        }


        Text scenetitle = new Text("Ebay-Amazon");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);


        Text finditem = new Text("Find an Item:");
        grid.add(finditem, 0,1);

        TextField searchTextField = new TextField();
        searchTextField.setPromptText("Search Item");
        grid.add(searchTextField, 0, 2);

        grid.add(getItemGrid(),0,3);

        Button logout = new Button("Log out");
        HBox logoutBtn = new HBox(10);
        logoutBtn.setAlignment(Pos.TOP_RIGHT);
        logoutBtn.getChildren().add(logout);
        grid.add(logoutBtn, 4, 0);

        Button search = new Button("Search");
        HBox searchBtn = new HBox(10);
        searchBtn.getChildren().add(search);
        grid.add(searchBtn, 1, 2);

        Button login1 = new Button("Refresh");
        HBox loginBtn1 = new HBox(10);
        loginBtn1.setAlignment(Pos.TOP_RIGHT);
        loginBtn1.getChildren().add(login1);
        grid.add(loginBtn1, 1, 0);

        Button sellItem = new Button("Sell Items");
        HBox sellBtn = new HBox(10);
        sellBtn.setAlignment(Pos.TOP_RIGHT);
        sellBtn.getChildren().add(sellItem);
        grid.add(sellBtn, 4, 2);

        VBox buttonBox = new VBox(10);


        Button submitComplaint = new Button("Submit Complaint");
        HBox submitComplaintBtn = new HBox(10);
        submitComplaintBtn.setAlignment(Pos.TOP_RIGHT);
        submitComplaintBtn.getChildren().add(submitComplaint);
        buttonBox.getChildren().add(submitComplaintBtn);

        Button editProfileBttn = new Button("Edit Profile");
        HBox editProfileBtn = new HBox(10);
        editProfileBtn.setAlignment(Pos.TOP_RIGHT);
        editProfileBtn.getChildren().add(editProfileBttn);
        buttonBox.getChildren().add(editProfileBtn);

        Button friends = new Button("Friends");
        HBox friendsBtn = new HBox(10);
        friendsBtn.setAlignment(Pos.TOP_RIGHT);
        friendsBtn.getChildren().add(friends);
        buttonBox.getChildren().add(friendsBtn);

        Button history = new Button("Transaction History");
        HBox historyBtn = new HBox(10);
        historyBtn.setAlignment(Pos.TOP_RIGHT);
        historyBtn.getChildren().add(history);
        buttonBox.getChildren().add(historyBtn);

        Button inbox = new Button("Notifications");
        HBox inboxBtn = new HBox(10);
        inboxBtn.setAlignment(Pos.TOP_RIGHT);
        inboxBtn.getChildren().add(inbox);
        buttonBox.getChildren().add(inboxBtn);
        grid.add(buttonBox,4,3);

        login1.setOnAction(e -> {
            ordhomepage = new OrdHomePage();
            ordhomepage.setPrimaryStage(primaryStage);
            primaryStage.setScene(ordhomepage);
            primaryStage.setTitle("Home Page");
            primaryStage.show();
        });

        editProfileBttn.setOnAction(( e -> {
            editProfile = new EditProfile();
            editProfile.setUsername(username);
            editProfile.setPrimaryStage(primaryStage);
            primaryStage.setScene(editProfile);
            primaryStage.setTitle("Edit Profile");
        }));

        sellItem.setOnAction(( e -> {
            SellItems sellitems = new SellItems();
            sellitems.setUsername(username);
            Stage window = sellitems.setWindow();
            window.setTitle("Sell Item");
            window.setWidth(390);
            window.setScene(sellitems);
            window.show();
        }));

        submitComplaint.setOnAction(( e -> {
            SubmitComplaintPage submitcomplaintpage = new SubmitComplaintPage();
            submitcomplaintpage.setUsername(username);
            Stage window = submitcomplaintpage.setWindow();
            window.setTitle("Submit Complaint");
            window.setWidth(300);
            window.setScene(submitcomplaintpage);
            window.show();
        }));

        friends.setOnAction(( e -> {
            friendspage = new FriendsPage(username);
            friendspage.setPrimaryStage(primaryStage);
            primaryStage.setScene(friendspage);
            primaryStage.setTitle("Friends");
        }));

        history.setOnAction(( e -> {
            ordtranshist = new OrdTransactionHistory();
            ordtranshist.setPrimaryStage(primaryStage);
            ordtranshist.setUsername(username);
            primaryStage.setTitle("Transaction History");
            primaryStage.setScene(ordtranshist);
        }));


        logout.setOnAction( e -> {
            guesthomepage = new GuestHomePage();
            guesthomepage.setPrimaryStage(primaryStage);
            primaryStage.setTitle("Guest Home Page");
            primaryStage.setScene(guesthomepage);
        });

        inbox.setOnAction( e -> {
            notificationspage = new NotificationsPage(username);
            notificationspage.openWindow();
        });

        search.setOnAction( e -> {
            grid.getChildren().remove(getNodeByRowColumnIndex(3,0,grid));

            String itemToSearch = searchTextField.getText();
            FlowPane itemGridSearch = new FlowPane();

            ArrayList<Item> itemSearchArrayList = Data.searchForItems(itemToSearch);

            ArrayList<Item> unregisteredItemArrayList = Data.getUnregisteredItems();


      //      for ( int k = 0; k < unregisteredItemArrayList.size(); k++){
       //         Data.registerItem(unregisteredItemArrayList.get(k).getItemID());
      //      }


            //IMPORTANT!!! Removes items from itemArrayList
//        for (int k = 0; k < unregisteredItemArrayList.size(); k++){
//            Data.removeItem(unregisteredItemArrayList.get(k).getItemID());
//        }


            for( int i = 0; i < itemSearchArrayList.size(); i++){
                itemList.add(new OrdItemsBox(itemSearchArrayList.get(i).getItemID(),itemSearchArrayList.get(i).getItemName(),itemSearchArrayList.get(i).getImageLocation(),username));
//                System.out.println(itemSearchArrayList.get(i).getItemName());
            }

            if (itemList.size() == 0){

            }
            else {
                for (int rowLength = 0; rowLength <= itemSearchArrayList.size(); rowLength++) {
                    itemGridSearch.getChildren().add(itemList.get(rowLength).getVbox());
                }
            }
            grid.add(itemGridSearch,0,3);

        });

    }

    public FlowPane getItemGrid() {
        FlowPane itemGrid = new FlowPane();


        ArrayList<Item> itemArrayList = Data.getItemsOnSale();
        ArrayList<Item> unregisteredItemArrayList = Data.getUnregisteredItems();

       // for ( int k = 0; k < unregisteredItemArrayList.size(); k++){
       //    Data.registerItem(unregisteredItemArrayList.get(k).getItemID());
      //  }


        //IMPORTANT!!! Removes items from itemArrayList
//        for (int k = 0; k < unregisteredItemArrayList.size(); k++){
//            Data.removeItem(unregisteredItemArrayList.get(k).getItemID());
//        }


        for( int i = 0; i < itemArrayList.size(); i++){

            itemList.add(new OrdItemsBox(itemArrayList.get(i).getItemID(),itemArrayList.get(i).getItemName(),itemArrayList.get(i).getImageLocation(),itemArrayList.get(i).getSeller()));

        }


        if (itemList.size() == 0){

        }
        else {
            for (int rowLength = 0; rowLength < itemArrayList.size(); rowLength++) {
                itemGrid.getChildren().add(itemList.get(rowLength).getVbox());

            }
        }
        return itemGrid;
    }

    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        return result;
    }
}
