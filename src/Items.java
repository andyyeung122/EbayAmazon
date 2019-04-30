import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Items extends Pane{
    VBox vbox = new VBox();
    Button btn = new Button("Details");
    Label label = new Label("Ordinary User");
    Pane pane = new Pane();

    public Items() {
        //Image pic = new Image();
        setName();
        setSeller();
        setPrice();
        vbox.getChildren().addAll(label, pane, btn );
        vbox.setVgrow(pane, Priority.ALWAYS);
    }

    private void setName() {

    }

    private void setSeller() {

    }

    private void setPrice() {

    }
}
