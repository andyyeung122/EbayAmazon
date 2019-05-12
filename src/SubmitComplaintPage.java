import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SubmitComplaintPage extends Scene {

    GridPane grid;
    private static Stage window = new Stage();
    private Main main = new Main();
    private static OrdHomePage ordhomepage = new OrdHomePage();

    public SubmitComplaintPage() {
        super(new GridPane(),600,300);
        grid = (GridPane)this.getRoot();
        grid.setHgap(10);
        grid.setVgap(10);

        Text scenetitle = new Text("Submit Complaint");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label title = new Label("Title:");
        grid.add(title, 0, 1);

        TextField titleTextField = new TextField();
        grid.add(titleTextField , 1, 1);

        Label message = new Label("Message:");
        grid.add(message, 0, 2);


        TextArea messageTextField = new TextArea();
        messageTextField.setMinWidth(50);
        messageTextField.setPrefWidth(50);
        messageTextField.setMaxWidth(400);
        messageTextField.setWrapText(true);     // New line of the text exceeds the text area
        messageTextField.setPrefRowCount(10);
        messageTextField.appendText("\n");

        grid.add(messageTextField , 1, 2);

        Button backtohome = new Button("Cancel");
        HBox backbtn = new HBox(10);
        backbtn.setAlignment(Pos.BOTTOM_LEFT);
        backbtn.getChildren().add(backtohome);
        grid.add(backtohome, 1, 3);

        Button submit = new Button("Submit");
        HBox submitbtn = new HBox(10);
        submitbtn.setAlignment(Pos.BASELINE_RIGHT);
        submitbtn.getChildren().add(submit);
        grid.add(submit, 0, 3);

        backtohome.setOnAction(( e -> {
            window.close();

        }));

    }

    public static Stage setWindow() {
        return window;
    }

}
