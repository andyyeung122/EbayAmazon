import com.sun.java.swing.plaf.windows.resources.windows;
import javafx.geometry.Pos;
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

import java.io.File;
import java.io.FileInputStream;

public class OrdItemsBox extends VBox{
    public VBox vbox = new VBox();
    public Pane pane = new Pane();
    public String cssLayout = "-fx-border-color: black;\n" +
            "-fx-border-insets: 5;\n" +
            "-fx-border-width: 3;\n";

    public boolean isFixed = false;
    public boolean isBid = false;
    private String username;
    private String password;

    public OrdItemsBox(int itemId, String itemNameString, String imageLocationString, String sellerString) {

        int totalPrice = Data.getFixedPrice(itemId);
        //Image pic = new Image();
        Button Detailsbtn = new Button("Details");
        Label label = new Label(itemNameString);
        File file = new File(imageLocationString);
        Image image = new Image(file.toURI().toString(),75,75,false,false);
        ImageView imageView = new ImageView(image);

        vbox.setStyle(cssLayout);
        vbox.setPrefWidth(10);
        vbox.setPrefHeight(40);
        vbox.getChildren().addAll(label, imageView, Detailsbtn );

        Detailsbtn.setOnAction(( e -> {
            File file2 = new File(imageLocationString);
            Image image2 = new Image(file2.toURI().toString(),75,75,false,false);
            ImageView imageView2 = new ImageView(image2);

            GridPane addgrid = new GridPane();
            addgrid.setHgap(10);
            addgrid.setVgap(10);
            addgrid.setAlignment(Pos.CENTER);

            Scene scene2 = new Scene(addgrid, 200,250);
            Stage window2 = new Stage();
            Text title2 = new Text("Item Detail");
            title2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            addgrid.add(title2, 0, 0, 2, 1);

            Text itemName = new Text("Item Name:" + " " + itemNameString);
            addgrid.add(itemName, 0,1);

            Text sellerName = new Text("Seller:" + " " + sellerString);
            addgrid.add(sellerName , 0, 2);

            addgrid.add(imageView2,0,3);

            Text price = new Text("" + totalPrice);
            addgrid.add(price,0,4);

            Button buyBtn = new Button("Buy");
            addgrid.add(buyBtn,0,5);

            buyBtn.setOnAction(( el -> {
                    Data.removeItem(itemId);
                    window2.close();
                    AlertBox alertbox = new AlertBox();
                    alertbox.display("Successful", "Item Bought!");

            }));

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
