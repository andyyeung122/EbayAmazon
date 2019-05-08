import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DeleteUser extends Application {
    public DeleteUser() {
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Super User!");
        GridPane deleteGrid = new GridPane();
        deleteGrid.setAlignment(Pos.CENTER);
        deleteGrid.setHgap(10.0D);
        deleteGrid.setVgap(10.0D);
        deleteGrid.setPadding(new Insets(25.0D, 25.0D, 25.0D, 25.0D));
        Scene scene = new Scene(deleteGrid, 400.0D, 400.0D);
        Text title = new Text("Delete User");
        deleteGrid.add(title, 0, 0, 2, 1);
        title.setFont(Font.font("Verdana", 20.0D));
        Label userName = new Label("User Name");
        deleteGrid.add(userName, 0, 1);
        TextField userName_tf = new TextField();
        deleteGrid.add(userName_tf, 1, 1);
        Label deleteMessage = new Label("Deletion Message");
        deleteGrid.add(deleteMessage, 0, 2);
        TextField deleteMessage_tf = new TextField();
        deleteGrid.add(deleteMessage_tf, 1, 2);
        Button removeUser = new Button("Remove User");
        HBox button = new HBox(10.0D);
        button.setAlignment(Pos.BOTTOM_RIGHT);
        button.getChildren().add(removeUser);
        deleteGrid.add(button, 1, 4);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
