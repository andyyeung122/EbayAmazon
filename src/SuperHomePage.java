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
import javafx.stage.Stage;

public class SuperHomePage extends Application {
    public SuperHomePage() {
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle(" Welcome Super User!");
        HBox topLabel = new HBox();
        Label label = new Label("EbayAmazon");
        label.setFont(Font.font("Verdana", 20.0D));
        label.setTextFill(Color.web("Black"));
        topLabel.getChildren().add(label);
        GridPane userFunction = new GridPane();
        userFunction.setAlignment(Pos.CENTER);
        userFunction.setHgap(10.0D);
        userFunction.setVgap(10.D);
        Button viewApplication = new Button("View Application");
        Button ViewProcessingItem = new Button("View Processing Items");
        Button sendMessage = new Button(" Send Message");
        Button viewHistory = new Button(" View History");
        Button tabooWord = new Button(" Taboo Word");
        Button deleteUser = new Button("Delete User");
        Button outstandingUser = new Button("Outstanding User");
        Button viewComplaints = new Button("View Complaints");

        userFunction.add(viewApplication,1,0);
        userFunction.add(ViewProcessingItem,1,1);
        userFunction.add(sendMessage,1,2);
        userFunction.add(viewHistory,1,3);
        userFunction.add(tabooWord,1,4);
        userFunction.add(deleteUser,1,5);
        userFunction.add(outstandingUser,1,6);
        userFunction.add(viewComplaints,1,7);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topLabel);
        borderPane.setRight(userFunction);
        Scene scene = new Scene(borderPane, 500.0D, 500.0D);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}