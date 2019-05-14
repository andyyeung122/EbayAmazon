import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//import java.time.LocalDate;


public class ViewTransactionHistory extends Application {


    public void start(Stage primaryStage) {
        primaryStage.setTitle("Super User");
        GridPane historyGrid = new GridPane();
        historyGrid.setAlignment(Pos.CENTER);
        historyGrid.setHgap(10);
        historyGrid.setVgap(10);
        historyGrid.setPadding(new Insets(25, 25, 25, 25));
        Scene historyScene = new Scene(historyGrid,470,470);
        Text title1 = new Text("View Transaction History");
        historyGrid.add(title1,0,0,2,1);
        title1.setFont(Font.font("Verdana", 15));
        Label UserName = new Label("User Name");
        historyGrid.add(UserName, 0, 1);
        ComboBox userID = new ComboBox();
        userID.getItems().addAll(
                "User_name1","ser_name1", "ser_name1"
        );
        historyGrid.add(userID,1 , 1);

        Label StartDate = new Label("Start date");
        historyGrid.add(StartDate, 0,2);
        DatePicker start  = new DatePicker();
        historyGrid.add(start, 1,2);


        Label EndDate =  new Label("End Date");
        historyGrid.add(EndDate, 0,3);
        DatePicker end = new DatePicker();
        historyGrid.add(end, 1,3);

        Button viewItem = new Button(" View Items");
        viewItem.setOnAction(action ->{
            //   LocalDate startDate = start.getValue();
            // LocalDate endDate   = start.getValue();
            GridPane secondaryLayout = new GridPane();
            Scene secondScene = new Scene(secondaryLayout, 300, 300);
            Stage secondStage = new Stage();
            secondStage.setTitle("Transaction History");
            secondStage.setScene(secondScene);
            TableView transactionTable = new TableView();
            TableColumn userName = new TableColumn("User Name");
            TableColumn itemName = new TableColumn("Item Name");
            TableColumn soldPurchase = new TableColumn("Sold/Purchase");
            transactionTable.getColumns().addAll(userName,itemName,soldPurchase);
            transactionTable.prefHeightProperty().bind(secondStage.heightProperty());
            transactionTable.prefWidthProperty().bind(secondStage.widthProperty());

            secondaryLayout.add(transactionTable,1,1);

            secondStage.show();
        });

        Button back = new Button("Back");
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                SuperHomePage sh = new SuperHomePage();
                sh.start(primaryStage);

            }
        });
        HBox viewIteMButton = new HBox(10.0D);
        viewIteMButton.setAlignment(Pos.BOTTOM_LEFT);
        viewIteMButton.getChildren().add(viewItem);
        viewIteMButton.getChildren().add(back);
        historyGrid.add(viewIteMButton, 1, 4);
        primaryStage.setScene(historyScene);
        primaryStage.show();
    }

}