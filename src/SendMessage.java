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

public class SendMessage extends Scene{

    GridPane grid;
    private Main main = new Main();
    private  SuperHomePage superHomePage=new SuperHomePage();


    public SendMessage (){
        super(new GridPane(),390,300);
        grid = (GridPane)this.getRoot();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text title = new Text("Send Message");
        grid.add(title,0,0,2,1);
        title.setFont(Font.font("Verdana", 20.0D));
        Label selectUser = new Label("User name");
        grid.add(selectUser, 0, 1);
        TextField  userName = new TextField();


        grid.add(userName, 1,1);
        Label sendMessage = new Label("Message");
        grid.add(sendMessage, 0, 2);
        TextField deleteMessage = new TextField();
        grid.add(deleteMessage, 1, 2);


        //send message to ordinary user
        Button send = new Button("Send");

        send.setOnAction(e->{
            String name =userName.getText();



        });


        Button back1 = new Button("Back");
        back1.setOnAction(e-> {
            main.getPrimaryStage().setScene(superHomePage);
            main.getPrimaryStage().setTitle("Home Page");
            main.getPrimaryStage().show();
        });

        HBox buttonbox = new HBox(10.0D);
        buttonbox.setAlignment(Pos.BOTTOM_LEFT);
        buttonbox.getChildren().addAll(send,back1);
        grid.add(buttonbox,1,3);


    }

}
