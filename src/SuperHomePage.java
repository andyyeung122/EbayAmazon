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


        // functions that super user can perform

        // view application for ordinary user
        Button viewApplication = new Button("View Application");
        viewApplication.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ViewApplication va = new ViewApplication();
                va.start(primaryStage);

            }
        });


        // accept or reject the processing items
        Button ViewProcessingItem = new Button("View Processing Items");
        ViewProcessingItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ViewProcessingItem pt = new ViewProcessingItem();
                pt.start(primaryStage);

            }
        });

        //Send message to ordinary user
        Button sendMessage = new Button(" Send Message");
        sendMessage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                SendMessage sm = new SendMessage();
                sm.start(primaryStage);

            }
        });


        // view transaction history of item sold or purchase
        Button viewHistory = new Button(" View History");
        viewHistory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ViewTransactionHistory history = new ViewTransactionHistory();
                history.start(primaryStage);

            }
        });

        // list of taboo words
        Button tabooWord = new Button(" Taboo Word");
        tabooWord.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                TabooWord tw= new TabooWord();
                tw.start(primaryStage);

            }
        });

        //delete user and sen them message
        Button deleteUser = new Button("Delete User");
        deleteUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                DeleteUser du = new DeleteUser();
                du.start(primaryStage);

            }
        });


        //view complaints from ordinary user and re
        Button viewComplaints = new Button("View Complaints");


        userFunction.add(viewApplication,1,0);
        userFunction.add(ViewProcessingItem,1,1);
        userFunction.add(sendMessage,1,2);
        userFunction.add(viewHistory,1,3);
        userFunction.add(tabooWord,1,4);
        userFunction.add(deleteUser,1,5);
        userFunction.add(viewComplaints,1,6);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topLabel);
        borderPane.setRight(userFunction);
        Scene scene = new Scene(borderPane, 500.0D, 500.0D);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}