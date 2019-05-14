import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class OrdTransactionHistory extends Scene {

    GridPane grid;
    private List<ItemsBox> soldItems = new ArrayList<>();
    private List<ItemsBox> purchasedItems = new ArrayList<>();
    private Main main = new Main();
    private static OrdHomePage ordhomepage = new OrdHomePage();


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
            TableView transactionTable = new TableView();
            TableColumn itemName = new TableColumn("Item Name");
            TableColumn soldPurchase = new TableColumn("Price Sold");
            transactionTable.getColumns().addAll(itemName,soldPurchase);
            transactionTable.prefHeightProperty().bind(secondStage.heightProperty());
            transactionTable.prefWidthProperty().bind(secondStage.widthProperty());
            soldPurchase.prefWidthProperty().bind(transactionTable.widthProperty().multiply(0.3));
            itemName.prefWidthProperty().bind(transactionTable.widthProperty().multiply(0.7));

            secondaryLayout.add(transactionTable,1,1);
            secondStage.show();
        }));

        viewPurchasedItems.setOnAction(( e -> {
            GridPane thirdLayout = new GridPane();
            Scene thirdScene = new Scene(thirdLayout, 350, 300);
            Stage thirdStage = new Stage();
            thirdStage.setTitle("Transaction History");
            thirdStage.setScene(thirdScene);
            TableView transactionTable = new TableView();
            TableColumn itemName = new TableColumn("Item Name");
            TableColumn soldPurchase = new TableColumn("Price Purchased");
            transactionTable.getColumns().addAll(itemName,soldPurchase);
            transactionTable.prefHeightProperty().bind(thirdStage.heightProperty());
            transactionTable.prefWidthProperty().bind(thirdStage.widthProperty());
            soldPurchase.prefWidthProperty().bind(transactionTable.widthProperty().multiply(0.3));
            itemName.prefWidthProperty().bind(transactionTable.widthProperty().multiply(0.7));

            thirdLayout.add(transactionTable,1,1);
            thirdStage.show();
        }));

        back.setOnAction(( e -> {
            main.getPrimaryStage().setScene(ordhomepage);
            main.getPrimaryStage().setTitle("Home Page");
            main.getPrimaryStage().show();
        }));
    }
}
