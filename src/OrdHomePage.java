import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import java.util.ArrayList;

public class OrdHomePage extends Scene{

    GridPane grid;
    private Data data = new Data();
    private List<ItemsBox> itemList = new ArrayList<>();
    private static Main main = new Main();
    private Stage primaryStage;
    private String username;
    private static EditProfile editProfile;
    private static ManageItemsPage manageitems = new ManageItemsPage();
    private static FriendsPage friendspage = new FriendsPage();
    private static OrdTransactionHistory ordtranshist = new OrdTransactionHistory();
    private static GuestHomePage guesthomepage;
    private static NotificationsPage notificationspage;


    public void setUsername(String username){
        this.username = username;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public OrdHomePage() {
        super(new GridPane(),400,550);
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

        Button logout = new Button("Log out");
        HBox logoutBtn = new HBox(10);
        logoutBtn.setAlignment(Pos.TOP_RIGHT);
        logoutBtn.getChildren().add(logout);
        grid.add(logoutBtn, 4, 0);

        Button search = new Button("Search");
        HBox searchBtn = new HBox(10);
        searchBtn.getChildren().add(search);
        grid.add(searchBtn, 1, 2);

        Button sellItem = new Button("Sell Items");
        HBox sellBtn = new HBox(10);
        sellBtn.setAlignment(Pos.TOP_RIGHT);
        sellBtn.getChildren().add(sellItem);
        grid.add(sellBtn, 4, 2);

        Button manage = new Button("Manage Items");
        HBox manageBtn = new HBox(10);
        manageBtn.setAlignment(Pos.TOP_RIGHT);
        manageBtn.getChildren().add(manage);
        grid.add(manageBtn, 4, 3);

        Button submitComplaint = new Button("Submit Complaint");
        HBox submitComplaintBtn = new HBox(10);
        submitComplaintBtn.setAlignment(Pos.TOP_RIGHT);
        submitComplaintBtn.getChildren().add(submitComplaint);
        grid.add(submitComplaintBtn, 4, 5);

        Button editProfileBttn = new Button("Edit Profile");
        HBox editProfileBtn = new HBox(10);
        editProfileBtn.setAlignment(Pos.TOP_RIGHT);
        editProfileBtn.getChildren().add(editProfileBttn);
        grid.add(editProfileBtn, 4, 1);

        Button friends = new Button("Friends");
        HBox friendsBtn = new HBox(10);
        friendsBtn.setAlignment(Pos.TOP_RIGHT);
        friendsBtn.getChildren().add(friends);
        grid.add(friendsBtn, 4, 6);

        Button history = new Button("Transaction History");
        HBox historyBtn = new HBox(10);
        historyBtn.setAlignment(Pos.TOP_RIGHT);
        historyBtn.getChildren().add(history);
        grid.add(historyBtn, 4, 4);

        Button inbox = new Button("Notifications");
        HBox inboxBtn = new HBox(10);
        inboxBtn.setAlignment(Pos.TOP_RIGHT);
        inboxBtn.getChildren().add(inbox);
        grid.add(inboxBtn, 4, 7);

//        itemList.add(new ItemsBox());
//        itemList.add(new ItemsBox());
//        itemList.add(new ItemsBox());
//        grid.add(itemList.get(0), 1,1);

        manage.setOnAction( e -> {

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

        manage.setOnAction(( e-> {
            main.getPrimaryStage().setScene(manageitems);
            main.getPrimaryStage().setTitle("Manage ItemsBox");
            main.getPrimaryStage().show();
        }));

        submitComplaint.setOnAction(( e -> {
            SubmitComplaintPage submitcomplaintpage = new SubmitComplaintPage();
            Stage window = submitcomplaintpage.setWindow();
            window.setTitle("Submit Complaint");
            window.setWidth(300);
            window.setScene(submitcomplaintpage);
            window.show();
        }));

        friends.setOnAction(( e -> {
            main.getPrimaryStage().setScene(friendspage);
            main.getPrimaryStage().setTitle("Friends");
            main.getPrimaryStage().show();
        }));

        history.setOnAction(( e -> {
            main.getPrimaryStage().setScene(ordtranshist);
            main.getPrimaryStage().setTitle("Transaction History");
            main.getPrimaryStage().show();
        }));


        logout.setOnAction( e -> {
            guesthomepage = new GuestHomePage();
            guesthomepage.setPrimaryStage(primaryStage);
            primaryStage.setTitle("Guest Home Page");
            primaryStage.setScene(guesthomepage);
        });

        inbox.setOnAction( e -> {
            notificationpage = new NotificationsPage();
            notificationpage.setUsername(username);
            notificationpage.showWindow();
        });


    }
}
