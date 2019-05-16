import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ViewProcessingItem extends Scene{

    GridPane grid;
    private Main main = new Main();
    private Stage primaryStage;
    private  SuperHomePage superhomepage;
    private Data data=new Data();
    TableView<Item>itemProcess;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public ViewProcessingItem() {

        super(new GridPane(),600,300);
        grid = (GridPane)this.getRoot();


        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25. , 25.));

        Text title1 = new Text("View Processing Item");
        grid.add(title1,0,0,2,1);
        title1.setFont(Font.font("Verdana", 20));


        // get data of item to sell from database

        TableColumn<Item,Integer> itemID = new TableColumn("Item Id");
        TableColumn<Item,String> itemName = new TableColumn(" Item Name");
        TableColumn <Item,String>seller = new TableColumn(" Seller");


        itemID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        itemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        seller.setCellValueFactory(new PropertyValueFactory<>("seller"));

        itemID.setMinWidth(100);
        itemName.setMinWidth(200);
        seller.setMinWidth(100);

        itemProcess = new TableView();

        ArrayList<Item> unregisteredItems = data.getUnregisteredItems();
        ObservableList<Item> datas= FXCollections.observableList(unregisteredItems);

        itemProcess.setItems(datas);
        itemProcess.getColumns().addAll(itemID,itemName,seller);
        grid.add(itemProcess, 1,2);

        //send message to ordinary user
        Button accept = new Button("Accept");
        accept.setOnAction(e->{
            ObservableList<Item> selected, allProduct;
            allProduct=itemProcess.getItems();
            selected=itemProcess.getSelectionModel().getSelectedItems();
            int itemID1=selected.get(0).getItemID();
            data.registerItem(itemID1);
            selected.forEach(allProduct::remove);

        });


        Button reject = new Button("Reject");
      reject.setOnAction(e->{

          ObservableList<Item> selected2, allProduct2;
          allProduct2=itemProcess.getItems();
          selected2=itemProcess.getSelectionModel().getSelectedItems();

          selected2.forEach(allProduct2::remove);


      });


        Button goBack =new Button("Back");
       goBack.setOnAction(e-> {
           superhomepage = new SuperHomePage();
           superhomepage.setPrimaryStage(primaryStage );
           primaryStage.setScene(superhomepage);
           primaryStage.setTitle("Home Page");
           primaryStage.show();

        });

        HBox allButton = new HBox(10.0);
        allButton.setAlignment(Pos.BOTTOM_LEFT);
        allButton.getChildren().addAll(accept,reject, goBack);
        grid.add(allButton,1,3);


    }

}
