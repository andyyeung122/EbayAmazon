import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GuestHomePage extends Scene {

    GridPane grid;

    public LoginPage loginpage;
    private static Main main = new Main();
    private Stage primaryStage;
    private List<ItemsBox> itemList = new ArrayList<>();

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public GuestHomePage() {
        super(new GridPane(),400,600);
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



//            main.getPrimaryStage().setScene(loginpage2);
//            main.getPrimaryStage().setTitle("Home Page");
//            main.getPrimaryStage().show();

//            primaryStage.setScene(loginpage2);
//            primaryStage.setTitle("Home Page");
//            primaryStage.show();

        });
    }

    public GridPane getItemGrid() {
        GridPane itemGrid = new GridPane();

        ColumnConstraints colConstraint = new ColumnConstraints(100);
        itemGrid.getColumnConstraints().add(colConstraint);

        Data.createFixedItem("bob","dude55","bob","bob,bob", 20);
        Data.createFixedItem("bob","dude55","bob","bob,bob", 20);
        Data.createFixedItem("bob","dude55","bob","bob,bob", 20);
        ArrayList<Item> itemArrayList = Data.getItemsOnSale();

        for( int i = 0; i < itemArrayList.size(); i++){
            itemList.add(new ItemsBox(itemArrayList.get(i).getItemName()));
            System.out.println(itemArrayList.get(i).getItemName());
        }

        if (itemList.size() == 0){

        }
        else {
            for (int rowLength = 0; rowLength < (itemArrayList.size()) / 3; rowLength++) {
                for (int columnLength = 0; columnLength < 2; columnLength++) {
                    itemGrid.add(itemList.get((3 * rowLength) + columnLength).getVbox(), rowLength, columnLength);
                }
            }
        }

//        itemList.add(new ItemsBox());
//        itemList.add(new ItemsBox());
//        itemGrid.add(itemList.get(0).getVbox(), 0,0);
//        itemGrid.add(itemList.get(1).getVbox(), 0,1);

        return itemGrid;
    }


}
