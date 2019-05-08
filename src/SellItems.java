import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

    public SellItems() {
        super(new GridPane(),390,300);
        grid = (GridPane)this.getRoot();
        grid.setHgap(10);
        grid.setVgap(10);

        Text findItem = new Text("Enter Item Detail:");
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

        final FileChooser fileChooser = new FileChooser();

        uploadImage.setOnAction(( e -> {
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                Image image = new Image(file.toURI().toString(), 140, 212, true, true);
                ImageView imageView = new ImageView(image);
                grid.add(imageView, 0,2);
            }

        }));

    }
}
