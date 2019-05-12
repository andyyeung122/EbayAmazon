import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class FriendsPage extends Scene {

    GridPane grid;
    private static Main main = new Main();
    private static OrdHomePage ordhomepage = new OrdHomePage();


    public FriendsPage() {
        super(new GridPane(),390,300);
        grid = (GridPane)this.getRoot();
        grid.setHgap(10);
        grid.setVgap(10);

        Text scenetitle = new Text("Friends");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Button addFriend = new Button("Add Friend");
        HBox addFriendBtn = new HBox(10);
        addFriendBtn.getChildren().add(addFriend);
        grid.add(addFriendBtn, 1, 1);

        Button deleteFriend = new Button("Delete");
        HBox deleteFriendBtn = new HBox(10);
        deleteFriendBtn.getChildren().add(deleteFriend);
        grid.add(deleteFriendBtn, 1,2);

        Button sendMessage = new Button("Send Message");
        HBox sendMessageBtn = new HBox(10);
        sendMessageBtn.getChildren().add(sendMessage);
        grid.add(sendMessageBtn, 1,3);

        Button backBtn = new Button("Back");
        grid.add(backBtn, 0,2);

        backBtn.setOnAction(( e -> {
            main.getPrimaryStage().setScene(ordhomepage);
            main.getPrimaryStage().setTitle("Home Page");
            main.getPrimaryStage().show();
        }));

        deleteFriend.setOnAction(( e -> {
            GridPane deletegrid = new GridPane();
            deletegrid.setHgap(10);
            deletegrid.setVgap(10);
            Scene scene = new Scene(deletegrid, 350,100);
            Stage window = new Stage();
            Text title = new Text("Are you sure you want to delete?");
            title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            deletegrid.add(title, 0, 0, 2, 1);

            Button deleteFriend2 = new Button("Delete");
            deletegrid.add(deleteFriend2, 0, 1);

            Button back2 = new Button("Back");
            deletegrid.add(back2,2,1);

            window.setTitle("Delete Friend");
            window.setScene(scene);
            window.show();

            back2.setOnAction(( el -> {
                window.close();
            }));
        }));

        addFriend.setOnAction(( e -> {
            GridPane addgrid = new GridPane();
            addgrid.setHgap(10);
            addgrid.setVgap(10);
            Scene scene2 = new Scene(addgrid, 350,100);
            Stage window2 = new Stage();
            Text title2 = new Text("Add Friend");
            title2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            addgrid.add(title2, 0, 0, 2, 1);

            Text username = new Text("Username: ");
            addgrid.add(username, 0,1);

            TextField usernameField = new TextField();
            addgrid.add(usernameField, 1, 1);

            Button addFriend2 = new Button("Add");
            addgrid.add(addFriend2, 0, 2);

            Button back3 = new Button("Back");
            addgrid.add(back3,2,2);

            window2.setTitle("Delete Friend");
            window2.setScene(scene2);
            window2.show();

            back3.setOnAction(( el -> {
                window2.close();
            }));
        }));

        sendMessage.setOnAction(( e -> {
            GridPane messagegrid = new GridPane();
            messagegrid.setHgap(10);
            messagegrid.setVgap(10);
            Scene scene3 = new Scene(messagegrid, 300,400);
            Stage window3 = new Stage();
            Text title3 = new Text("Send Message");
            title3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            messagegrid.add(title3, 0, 0, 2, 1);

            Text title = new Text("Tile: ");
            messagegrid.add(title, 0,1);

            TextField titleField = new TextField();
            messagegrid.add(titleField, 1, 1);

            Text message = new Text("Message: ");
            messagegrid.add(message, 0,2);

            TextArea messageField = new TextArea();
            messageField.setMinWidth(50);
            messageField.setPrefWidth(50);
            messageField.setMaxWidth(400);
            messageField.setWrapText(true);     // New line of the text exceeds the text area
            messageField.setPrefRowCount(10);
            messageField.appendText("\n");
            messagegrid.add(messageField, 1, 2);

            Button addFriend2 = new Button("Send");
            messagegrid.add(addFriend2, 0, 3);

            Button back3 = new Button("Back");
            messagegrid.add(back3,1,3);

            window3.setTitle("Send Message");
            window3.setScene(scene3);
            window3.show();

            back3.setOnAction(( el -> {
                window3.close();
            }));
        }));

    }
}
