import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GuestHomePage extends Scene {

    GridPane grid;

    public LoginPage loginpage;
    private static Main main = new Main();
    private Stage primaryStage;
    private List<ItemsBox> itemList = new ArrayList<>();
    private GuestHomePage guesthomepage;

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public GuestHomePage() {
        super(new GridPane(),570,600);
        grid = (GridPane)this.getRoot();
        grid.setHgap(10);
        grid.setVgap(10);

        Text scenetitle = new Text("Ebay-Amazon");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Text finditem = new Text("Find an Item:");
        grid.add(finditem, 0,1);

        TextField searchTextField = new TextField();
        searchTextField.setPromptText("Search Item");
        grid.add(searchTextField, 0, 2);

        Button login = new Button("Log in");
        HBox loginBtn = new HBox(10);
        loginBtn.setAlignment(Pos.TOP_RIGHT);
        loginBtn.getChildren().add(login);
        grid.add(loginBtn, 5, 0);

        Button search = new Button("Search");
        HBox searchBtn = new HBox(10);
        searchBtn.getChildren().add(search);
        grid.add(searchBtn, 1, 2);
        

        grid.add(getItemGrid(), 0, 3);


        // Link to DB
        login.setOnAction( e -> {
            loginpage = new LoginPage();
            loginpage.setPrimaryStage(primaryStage);
            primaryStage.setScene(loginpage);
            primaryStage.setTitle("Login");
            primaryStage.show();
        });

        search.setOnAction( e -> {
        grid.getChildren().remove(getNodeByRowColumnIndex(3,0,grid));

            String itemToSearch = searchTextField.getText();
            FlowPane itemGridSearch = new FlowPane();

            ArrayList<Item> itemSearchArrayList = Data.searchForItems(itemToSearch);

            ArrayList<Item> unregisteredItemArrayList = Data.getUnregisteredItems();

            for ( int k = 0; k < unregisteredItemArrayList.size(); k++){
                Data.registerItem(unregisteredItemArrayList.get(k).getItemID());
            }

            //IMPORTANT!!! Removes items from itemArrayList
//        for (int k = 0; k < unregisteredItemArrayList.size(); k++){
//            Data.removeItem(unregisteredItemArrayList.get(k).getItemID());
//        }


            for( int i = 0; i < itemSearchArrayList.size(); i++){
                itemList.add(new ItemsBox(itemSearchArrayList.get(i).getItemID(),itemSearchArrayList.get(i).getItemName(),itemSearchArrayList.get(i).getImageLocation(),itemSearchArrayList.get(i).getSeller()));
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

        for ( int k = 0; k < unregisteredItemArrayList.size(); k++){
            Data.registerItem(unregisteredItemArrayList.get(k).getItemID());
        }

          //IMPORTANT!!! Removes items from itemArrayList
//        for (int k = 0; k < itemArrayList.size(); k++){
//            Data.removeItem(itemArrayList.get(k).getItemID());
//        }


        for( int i = 0; i < itemArrayList.size(); i++){
            itemList.add(new ItemsBox(itemArrayList.get(i).getItemID(),itemArrayList.get(i).getItemName(),itemArrayList.get(i).getImageLocation(),itemArrayList.get(i).getSeller()));
            System.out.println(itemArrayList.get(i).getItemName());
        }


        if (itemList.size() == 0){

        }
//        else if(((double)((itemArrayList.size()) / 3)) == 0) {
//            for (int rowLength = 0; rowLength < ((double)((itemArrayList.size()) / 3)); rowLength++) {
//                for (int columnLength = 0; columnLength < itemArrayList.size(); columnLength++) {
//                    itemGrid.getChildren().add(itemList.get((3 * rowLength) + columnLength).getVbox());
//                }
//            }
//        }
        else {
            for (int rowLength = 0; rowLength < itemArrayList.size(); rowLength++) {
                    itemGrid.getChildren().add(itemList.get(rowLength).getVbox());
                    System.out.println((double)((itemArrayList.size()) / 3));
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
