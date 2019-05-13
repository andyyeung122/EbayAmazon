import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SuperHomePage extends Scene {
          GridPane grid;


    public SuperHomePage() {


        super(new GridPane(),600,550);
        grid = (GridPane)this.getRoot();
        grid.setHgap(10);
        grid.setVgap(10);

        Text scenetitle = new Text(" Welcome Super User!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);






        Button viewApplication = new Button("View Application");
        Button ViewProcessingItem = new Button("View Processing Items");
        Button sendMessage = new Button(" Send Message");
        Button viewHistory = new Button(" View History");
        Button tabooWord = new Button(" Taboo Word");
        Button deleteUser = new Button("Delete User");
        Button outstandingUser = new Button("Outstanding User");
        Button viewComplaints = new Button("View Complaints");

        grid.add(viewApplication,2,1);
        grid.add(ViewProcessingItem,2,2);
        grid.add(sendMessage,2,3);
        grid.add(viewHistory,2,4);
        grid.add(tabooWord,2,5);
        grid.add(deleteUser,2,6);
        grid.add(outstandingUser,2,7);
        grid.add(viewComplaints,2,8);


    }






}