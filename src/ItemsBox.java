import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ItemsBox extends VBox{
    public VBox vbox = new VBox();
    public Pane pane = new Pane();
    public String cssLayout = "-fx-border-color: black;\n" +
            "-fx-border-insets: 5;\n" +
            "-fx-border-width: 3;\n";

    public boolean isFixed = false;
    public boolean isBid = false;

    public ItemsBox(String itemNameString) {
        //Image pic = new Image();
        Button Detailsbtn = new Button("Details");
        Label label = new Label(itemNameString);
//        Image image = new Image(imageLocationString);
//        ImageView imageView = new ImageView(image);

        vbox.setStyle(cssLayout);
        vbox.setPrefWidth(10);
        vbox.setPrefHeight(40);
        vbox.getChildren().addAll(label, Detailsbtn );

        Detailsbtn.setOnAction(( e -> {
            GridPane addgrid = new GridPane();
            addgrid.setHgap(10);
            addgrid.setVgap(10);
            Scene scene2 = new Scene(addgrid, 300,200);
            Stage window2 = new Stage();
            Text title2 = new Text("Item Detail");
            title2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            addgrid.add(title2, 0, 0, 2, 1);

            Text itemName = new Text("Item Name: ");
            addgrid.add(itemName, 0,1);

            Text sellerName = new Text("Seller:");
            addgrid.add(sellerName , 0, 2);

            Button buyBtn = new Button("Buy");
            addgrid.add(buyBtn,0,3);


            window2.setTitle("Item Detail");
            window2.setScene(scene2);
            window2.show();
        }));
    }

    public VBox getVbox() {
        return vbox;
    }

    private void setIsFixed() {
        isFixed = !isFixed;
    }

    private void setIsBid() {
        isBid = !isBid;
    }
}
