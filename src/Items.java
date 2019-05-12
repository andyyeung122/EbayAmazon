import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Items extends VBox{
    public VBox vbox = new VBox();
    public Pane pane = new Pane();
    public String cssLayout = "-fx-border-color: black;\n" +
            "-fx-border-insets: 5;\n" +
            "-fx-border-width: 3;\n";

    public boolean isFixed = false;
    public boolean isBid = false;

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

    private void setIsFixed() {
        isFixed = !isFixed;
    }

    private void setIsBid() {
        isBid = !isBid;
    }
}
