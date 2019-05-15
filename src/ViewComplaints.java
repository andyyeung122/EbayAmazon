import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class ViewComplaints  extends Scene {

    GridPane grid;
    private Main main = new Main();
    private  SuperHomePage superHomePage=new SuperHomePage();
    private Data data=new Data();
    TableView<Complaint>userApplication;
    public ViewComplaints() {
        super(new GridPane(),1000,700);
        grid = (GridPane)this.getRoot();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text title1 = new Text("View Complaint");
        grid.add(title1,0,0,2,1);
        title1.setFont(Font.font("Verdana", 15));


        TableColumn<Complaint,String> title = new TableColumn("Title");

        TableColumn<Complaint,String> message = new TableColumn(" Message");
        TableColumn<Complaint,String> sender = new TableColumn("Sender");


        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        message.setCellValueFactory(new PropertyValueFactory<>("message"));
        sender.setCellValueFactory(new PropertyValueFactory<>("sender"));


        title.setMinWidth(100);

        message.setMinWidth(400);
        sender.setMinWidth(50);


        userApplication = new TableView();

        ArrayList<Complaint> unhandledComplaint = data.getUnhandledComplaints();
        ObservableList<Complaint> datas= FXCollections.observableList(unhandledComplaint);
        unhandledComplaint.get(0).getID();

       userApplication.setItems(datas);




        userApplication.getColumns().addAll(title,message,sender);


        grid.add(userApplication, 1,2);







        Button back = new Button("Back");
        back.setOnAction(e-> {
            main.getPrimaryStage().setScene(superHomePage);
            main.getPrimaryStage().setTitle("Home Page");
            main.getPrimaryStage().show();


        });

        Button handle = new Button("Handled");
        handle.setOnAction(e->{


            ObservableList<Complaint> selected, allProduct;
            allProduct=userApplication.getItems();
            selected=userApplication.getSelectionModel().getSelectedItems();
            int Cid=selected.get(0).getID();
            data.handleComplaint(Cid);
            selected.forEach(allProduct::remove);


        });







        HBox allButton = new HBox(10);
        allButton.setAlignment(Pos.BOTTOM_LEFT);
        allButton.getChildren().addAll(handle,back);
        grid.add(allButton,1,3);





    }
}