import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class OrdTransactionHistory extends Scene {

    GridPane grid;
    private List<ItemsBox> soldItems = new ArrayList<>();
    private List<ItemsBox> purchasedItems = new ArrayList<>();
    private OrdHomePage ordhomepage;
    private Stage primaryStage;
    private String username;

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public OrdTransactionHistory() {
        super(new GridPane(),390,300);
        grid = (GridPane)this.getRoot();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);

        Text scenetitle = new Text("Transaction History");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Button viewSoldItems = new Button("View Sold ItemsBox");
        grid.add(viewSoldItems,0,1);

        Button viewPurchasedItems = new Button("View Purchased ItemsBox");
        grid.add(viewPurchasedItems,1,1);

        Button back = new Button("Back");
        grid.add(back,0,3);

        viewSoldItems.setOnAction(( e -> {
            GridPane secondaryLayout = new GridPane();
            Scene secondScene = new Scene(secondaryLayout, 300, 300);
            Stage secondStage = new Stage();
            secondStage.setTitle("Transaction History");
            secondStage.setScene(secondScene);
            ObservableList<Item> listOfItems = FXCollections.observableArrayList(Data.getItemsSoldBy(username));
            for(Item item : listOfItems)
                item.calculatePrice();
            TableView transactionTable = new TableView(listOfItems);
            TableColumn<Item, String> itemName = new TableColumn("Item Name");
            TableColumn<Item, String> soldPurchase = new TableColumn("Price Sold");
            transactionTable.getColumns().addAll(itemName,soldPurchase);
            transactionTable.prefHeightProperty().bind(secondStage.heightProperty());
            transactionTable.prefWidthProperty().bind(secondStage.widthProperty());
            soldPurchase.prefWidthProperty().bind(transactionTable.widthProperty().multiply(0.3));
            itemName.prefWidthProperty().bind(transactionTable.widthProperty().multiply(0.7));

            itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            soldPurchase.setCellValueFactory(new PropertyValueFactory<>("soldPrice"));

            secondaryLayout.add(transactionTable,1,1);
            secondStage.show();
        }));

        viewPurchasedItems.setOnAction(( e -> {
            GridPane thirdLayout = new GridPane();
            Scene thirdScene = new Scene(thirdLayout, 350, 300);
            Stage thirdStage = new Stage();
            thirdStage.setTitle("Transaction History");
            thirdStage.setScene(thirdScene);
            ObservableList<Item> listOfItems = FXCollections.observableArrayList(Data.getItemsPurchasedBy(username));
            for(Item item : listOfItems)
                item.calculatePrice();
            TableView transactionTable = new TableView(listOfItems);
            TableColumn itemName = new TableColumn("Item Name");
            TableColumn soldPurchase = new TableColumn("Price Purchased");
            transactionTable.getColumns().addAll(itemName,soldPurchase);
            transactionTable.prefHeightProperty().bind(thirdStage.heightProperty());
            transactionTable.prefWidthProperty().bind(thirdStage.widthProperty());
            soldPurchase.prefWidthProperty().bind(transactionTable.widthProperty().multiply(0.3));
            itemName.prefWidthProperty().bind(transactionTable.widthProperty().multiply(0.7));

            itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            soldPurchase.setCellValueFactory(new PropertyValueFactory<>("soldPrice"));

            thirdLayout.add(transactionTable,1,1);
            thirdStage.show();
        }));

        back.setOnAction(( e -> {
            ordhomepage = new OrdHomePage();
            ordhomepage.setPrimaryStage(primaryStage);
            ordhomepage.setUsername(username);
            primaryStage.setScene(ordhomepage);
            primaryStage.setTitle("Home Page");
            primaryStage.show();
        }));
    }
}
