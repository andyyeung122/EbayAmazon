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

public class ViewProcessingItem extends Application{



    public void start(Stage primaryStage) {
        primaryStage.setTitle("Super User!");
        GridPane itemGrid = new GridPane();
        itemGrid.setAlignment(Pos.CENTER);
        itemGrid.setHgap(10);
        itemGrid.setVgap(10);
        itemGrid.setPadding(new Insets(25, 25, 25. , 25.0D));
        Scene scene = new Scene(itemGrid, 400.0, 400);
        Text title1 = new Text("View Processing Item");
        itemGrid.add(title1,0,0,2,1);
        title1.setFont(Font.font("Verdana", 20));


        // get data of item to sell from database
        TableView processingItem = new TableView();
        TableColumn itemID = new TableColumn("Item Id");
        TableColumn itemName = new TableColumn(" Item Name");
        TableColumn seller = new TableColumn(" Seller");
        processingItem.getColumns().add(itemID);
        processingItem.getColumns().add(itemName);
        processingItem.getColumns().add(seller);

        itemGrid.add(processingItem, 1,2);

        //send message to ordinary user
        Button accept = new Button("Accept");


        Button reject = new Button("Reject");
        //reject.setOnAction(new EventHandler<ActionEvent>() {

        // });


        Button goBack =new Button("Back");
        goBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                SuperHomePage hg = new SuperHomePage();
                hg.start(primaryStage);

            }
        });

        HBox allButton = new HBox(10.0);
        allButton.setAlignment(Pos.BOTTOM_LEFT);
        allButton.getChildren().addAll(accept,reject, goBack);
        itemGrid.add(allButton,1,3);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
