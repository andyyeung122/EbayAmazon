import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class OrdHomePage extends Scene{

    GridPane grid;

    public OrdHomePage() {
        super(new GridPane(),600,600);
        grid = (GridPane)this.getRoot();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        Text scenetitle = new Text("Ebay-Amazon");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        TextField searchTextField = new TextField();
        searchTextField.setPromptText("Search");
        grid.add(searchTextField, 0, 1);

        Button search = new Button("Search");
        HBox searchBtn = new HBox(10);
        searchBtn.getChildren().add(search);
        grid.add(searchBtn, 1, 1);


    }
}
