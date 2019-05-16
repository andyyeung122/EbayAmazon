

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
import javafx.application.Application;

public class SuperHomePage extends Scene {


    GridPane grid;
    private String username;
    private Main main = new Main();
    private Stage primaryStage;
    private  GuestHomePage guesthomepage;
    private static ViewTransactionHistory viewTransactionHistory;
    private static ViewProcessingItem viewProcessingItems;
    private static ViewApplication viewApplications;
    private static TabooWord tabooWords;
    private static SendMessage sendMessages;
    private static ViewComplaints viewComplaint;
    private static OrdinaryUser ordinaryUser;
    private  static DeleteUser deleteUsers;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public SuperHomePage() {


        super(new GridPane(), 600, 550);
        grid = (GridPane) this.getRoot();
        grid.setHgap(10);
        grid.setVgap(10);

        Text scenetitle = new Text(" Welcome Super User!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);


        Button viewApplication = new Button("View Application");
        Button viewProcessingItem = new Button("View Processing Items");
        Button sendMessage = new Button(" Send Message");
        Button viewHistory = new Button(" View History");
        Button tabooWord = new Button(" Taboo Word");
        Button deleteUser = new Button("Delete User");
        Button outstandingUser = new Button("Outstanding User");
        Button viewComplaints = new Button("View Complaints");
        Button logout=new Button("Logout");

        grid.add(viewApplication, 2, 1);
        grid.add(viewProcessingItem, 2, 2);
        grid.add(sendMessage, 2, 3);
        grid.add(viewHistory, 2, 4);
        grid.add(tabooWord, 2, 5);
        grid.add(deleteUser, 2, 6);
        grid.add(outstandingUser, 2, 7);
        grid.add(viewComplaints, 2, 8);
        grid.add(logout, 2, 9);


        viewHistory.setOnAction( e -> {
            viewTransactionHistory = new ViewTransactionHistory();
            viewTransactionHistory.setPrimaryStage(primaryStage );
            primaryStage.setScene(viewTransactionHistory);
            primaryStage.setTitle("Home Page");
            primaryStage.show();
        });

        logout.setOnAction( e -> {
            guesthomepage = new GuestHomePage();
            guesthomepage.setPrimaryStage(primaryStage );
            primaryStage.setScene(guesthomepage);
            primaryStage.setTitle("Home Page");
            primaryStage.show();

        });

        viewProcessingItem.setOnAction(e->{
            viewProcessingItems = new ViewProcessingItem();
            viewProcessingItems.setPrimaryStage(primaryStage );
            primaryStage.setScene(viewProcessingItems);
            primaryStage.setTitle("Home Page");
            primaryStage.show();


        });

        viewApplication.setOnAction(e->{
            viewApplications = new ViewApplication();
            viewApplications.setPrimaryStage(primaryStage );
            primaryStage.setScene(viewApplications);
            primaryStage.setTitle("Home Page");
            primaryStage.show();


        });

        tabooWord.setOnAction(e->{
            tabooWords = new TabooWord();
            tabooWords.setPrimaryStage(primaryStage );
            primaryStage.setScene(tabooWords);
            primaryStage.setTitle("Home Page");
            primaryStage.show();


        });

        sendMessage.setOnAction(e->{
            sendMessages = new SendMessage();
            sendMessages.setPrimaryStage(primaryStage );
            primaryStage.setScene(sendMessages);
            primaryStage.setTitle("Home Page");
            primaryStage.show();


        });
        viewComplaints.setOnAction(e->{
            viewComplaint = new ViewComplaints();
            viewComplaint.setPrimaryStage(primaryStage );
            primaryStage.setScene(viewComplaint);
            primaryStage.setTitle("Home Page");
            primaryStage.show();

        });

        outstandingUser.setOnAction(e->{

            ordinaryUser = new OrdinaryUser();
            ordinaryUser.setPrimaryStage(primaryStage );
            primaryStage.setScene(ordinaryUser);
            primaryStage.setTitle("Home Page");
            primaryStage.show();

        });

        deleteUser.setOnAction(e->{

            deleteUsers = new DeleteUser();
            deleteUsers.setPrimaryStage(primaryStage );
            primaryStage.setScene(deleteUsers);
            primaryStage.setTitle("Home Page");
            primaryStage.show();

        });

    }

}