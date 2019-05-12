import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class ManageItemsPage extends Scene {

    GridPane grid;
    private List<Items> currentSellingItemsList = new ArrayList<>();
    private static Main main = new Main();
    private static OrdHomePage ordhomepage = new OrdHomePage();


    public ManageItemsPage () {
        super(new GridPane(),400,600);
        grid = (GridPane)this.getRoot();
        grid.setHgap(10);
        grid.setVgap(10);

        Text scenetitle = new Text("Manage Items");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        grid.add(getItemGrid(), 0,1);

        Button cancel = new Button("Back");

        cancel.setOnAction(( e -> {
            main.getPrimaryStage().setScene(ordhomepage);
            main.getPrimaryStage().setTitle("Home Page");
            main.getPrimaryStage().show();
        }));

        grid.add(cancel, 0,2);
    }



    public GridPane getItemGrid() {
        GridPane itemGrid = new GridPane();
        ColumnConstraints colConstraint = new ColumnConstraints(100);

        itemGrid.getColumnConstraints().add(colConstraint);

        currentSellingItemsList.add(new Items());
        currentSellingItemsList.add(new Items());
        itemGrid.add(currentSellingItemsList.get(0).getVbox(), 0,0);
        itemGrid.add(currentSellingItemsList.get(1).getVbox(), 0,1);

        return itemGrid;
    }

}
