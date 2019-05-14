import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.control.ComboBox;

public class SendMessage extends Application{



    public void start(Stage primaryStage) {
        primaryStage.setTitle("Super User");
        GridPane messageGrid = new GridPane();
        messageGrid.setAlignment(Pos.CENTER);
        messageGrid.setHgap(10.0D);
        messageGrid.setVgap(10.D);
        messageGrid.setPadding(new Insets(25.0D, 25.0D, 25.0D, 25.0D));
        Scene scene = new Scene(messageGrid, 400, 400);
        Text title = new Text("Send Message");
        messageGrid.add(title,0,0,2,1);
        title.setFont(Font.font("Verdana", 20.0D));
        Label selectUser = new Label("Select User");
        messageGrid.add(selectUser, 0, 1);
        ComboBox userName = new ComboBox();
        userName.getItems().addAll(
                "User_name1","User_name2", "User_name3"
        );
        messageGrid.add(userName, 1,1);
        Label sendMessage = new Label("Message");
        messageGrid.add(sendMessage, 0, 2);
        TextField deleteMessage = new TextField();
        messageGrid.add(deleteMessage, 1, 2);


        //send message to ordinary user
        Button send = new Button("Send");


        Button back1 = new Button("Back");
        back1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                SuperHomePage sh = new SuperHomePage();


            }
        });

        HBox buttonbox = new HBox(10.0D);
        buttonbox.setAlignment(Pos.BOTTOM_LEFT);
        buttonbox.getChildren().addAll(send,back1);
        messageGrid.add(buttonbox,1,3);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
