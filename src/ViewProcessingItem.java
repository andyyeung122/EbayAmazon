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

public class ViewProcessingItem extends Scene{

    GridPane grid;
    private Main main = new Main();
    private  SuperHomePage superHomePage=new SuperHomePage();

    public ViewProcessingItem() {

        super(new GridPane(),390,300);
        grid = (GridPane)this.getRoot();


        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25. , 25.));

        Text title1 = new Text("View Processing Item");
        grid.add(title1,0,0,2,1);
        title1.setFont(Font.font("Verdana", 20));


        // get data of item to sell from database
        TableView processingItem = new TableView();
        TableColumn itemID = new TableColumn("Item Id");
        TableColumn itemName = new TableColumn(" Item Name");
        TableColumn seller = new TableColumn(" Seller");
        processingItem.getColumns().add(itemID);
        processingItem.getColumns().add(itemName);
        processingItem.getColumns().add(seller);

        grid.add(processingItem, 1,2);

        //send message to ordinary user
        Button accept = new Button("Accept");


        Button reject = new Button("Reject");
        //reject.setOnAction(new EventHandler<ActionEvent>() {

        // });


        Button goBack =new Button("Back");
       goBack.setOnAction(e-> {
             main.getPrimaryStage().setScene(superHomePage);
            main.getPrimaryStage().setTitle("Home Page");
            main.getPrimaryStage().show();

        });

        HBox allButton = new HBox(10.0);
        allButton.setAlignment(Pos.BOTTOM_LEFT);
        allButton.getChildren().addAll(accept,reject, goBack);
        grid.add(allButton,1,3);


    }

}
