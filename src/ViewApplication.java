

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

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

public class ViewApplication extends Scene{

    GridPane grid;
    private Main main = new Main();
    private Stage primaryStage;
    private  SuperHomePage superhomepage;
    private Data data=new Data();
    TableView<User>userApplication;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public ViewApplication() {
            super(new GridPane(),1000,700);
            grid = (GridPane)this.getRoot();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);


            grid.setPadding(new Insets(25.0, 25, 25. , 25.0D));

            Text title1 = new Text("Ordinary User Application");
            grid.add(title1,0,0,2,1);
            title1.setFont(Font.font("Verdana", 20.0));

            // get data of item to sell from database

            TableColumn<User,String> name = new TableColumn("Name");
            TableColumn<User,String> userName = new TableColumn("UserName");

            TableColumn<User,String> address = new TableColumn(" Address");
            TableColumn<User,String> phone = new TableColumn("Phone Number");
            TableColumn<User,String> creditCard = new TableColumn("Card");

            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            userName.setCellValueFactory(new PropertyValueFactory<>("username"));
            address.setCellValueFactory(new PropertyValueFactory<>("address"));
            creditCard.setCellValueFactory(new PropertyValueFactory<>("creditCard"));
            phone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

            name.setMinWidth(100);
            userName.setMinWidth(100);

            address.setMinWidth(200);
            phone.setMinWidth(200);
            creditCard.setMinWidth(200);

            userApplication = new TableView();

            ArrayList<User> unregisteredUsers = data.getUnregisteredUsers();
            ObservableList<User> datas= FXCollections.observableList(unregisteredUsers);

            userApplication.setItems(datas);



            userApplication.getColumns().addAll(name,userName,address,phone,creditCard);


            grid.add(userApplication, 1,2);

            //send message to ordinary user
            Button addUser = new Button("Accept");


            addUser.setOnAction(e->{


                ObservableList<User> selected, allProduct;
                allProduct=userApplication.getItems();
                selected=userApplication.getSelectionModel().getSelectedItems();
                String Name=selected.get(0).getUsername();
                data.registerUser(Name);
                selected.forEach(allProduct::remove);


            });


            Button rejectUser = new Button("Reject");
            rejectUser.setOnAction(e->{
                ObservableList<User> selected2, allProduct2;
                allProduct2=userApplication.getItems();
                selected2=userApplication.getSelectionModel().getSelectedItems();

                selected2.forEach(allProduct2::remove);

            });


            Button home =new Button("Back");
            home.setOnAction(e-> {
                superhomepage = new SuperHomePage();
                superhomepage.setPrimaryStage(primaryStage );
                primaryStage.setScene(superhomepage);
                primaryStage.setTitle("Home Page");
                primaryStage.show();


            });

            HBox allButton = new HBox(10);
            allButton.setAlignment(Pos.BOTTOM_LEFT);
            allButton.getChildren().addAll(addUser,rejectUser,home);
            grid.add(allButton,1,3);


        }

    }