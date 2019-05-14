import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Items extends VBox{
    VBox vbox = new VBox();
    Pane pane = new Pane();
    String cssLayout = "-fx-border-color: black;\n" +
            "-fx-border-insets: 5;\n" +
            "-fx-border-width: 3;\n";


    public Items() {
        //Image pic = new Image();
        setName();
        setSeller();
        setPrice();
        Button btn = new Button("Details");
        Label label = new Label("Ordinary User");
        vbox.setStyle(cssLayout);
        vbox.setPrefWidth(10);
        vbox.setPrefHeight(40);
        vbox.getChildren().addAll(label, btn );
    }

    public VBox getVbox() {
        return vbox;
    }

    private void setName() {

    }

    private void setSeller() {

    }

    private void setPrice() {

    }
}
