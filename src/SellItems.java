import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class SellItems extends Scene {
    GridPane grid;
    Stage stage;
    private static Stage window = new Stage();


    public SellItems() {
        super(new GridPane(),390,300);
        grid = (GridPane)this.getRoot();
        grid.setHgap(10);
        grid.setVgap(10);

        Text findItem = new Text("Enter Item Details:");
        grid.add(findItem, 0,0);

        Button uploadImage = new Button("Upload Image");
        HBox uploadImageBtn = new HBox();
        uploadImageBtn.getChildren().add(uploadImage);
        grid.add(uploadImageBtn,0,1);

        Text itemName = new Text("Item Name:");
        grid.add(itemName, 0,3);

        TextField itemNameField = new TextField();
        itemNameField.setPromptText("Search Item");
        grid.add(itemNameField, 1, 3);

        TextField totalPriceField = new TextField();
        totalPriceField.setPromptText("Price");

        Text totalPrice = new Text("");
        grid.add(totalPrice, 0,5);

        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton bidPrice = new RadioButton("Bid Price");
        grid.add(bidPrice,0,4);

        RadioButton fixedPrice = new RadioButton("Fixed Price");
        grid.add(fixedPrice,1,4);

        Button addItem = new Button("Add Item");
        grid.add(addItem,0,6);

        Button cancelItem = new Button("Cancel");
        grid.add(cancelItem,1,6);

        bidPrice.setToggleGroup(toggleGroup);
        fixedPrice.setToggleGroup(toggleGroup);

        final FileChooser fileChooser = new FileChooser();

        cancelItem.setOnAction((e -> {
            window.close();
        }));

        uploadImage.setOnAction(( e -> {
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                Image image = new Image(file.toURI().toString(), 140, 212, true, true);
                ImageView imageView = new ImageView(image);
                grid.add(imageView, 0,2);
            }

        }));

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n)
            {
                RadioButton rb = (RadioButton)toggleGroup.getSelectedToggle();
                    if (rb.getText() == "Bid Price") {
                        totalPrice.setText("Total Price");
                        grid.getChildren().remove(totalPriceField);
                        grid.add(totalPriceField,1,5);

                    }

                    else if (rb.getText() == "Fixed Price") {
                        totalPrice.setText("Starting Bid Price");
                        grid.getChildren().remove(totalPriceField);
                        grid.add(totalPriceField,1,5);

                    }
                }

        });

    }

    public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }
        return result;
    }
    public static Stage setWindow() {
        return window;
    }
}
