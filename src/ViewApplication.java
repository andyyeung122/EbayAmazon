

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

public class ViewApplication extends Scene{

    GridPane grid;
    private Main main = new Main();
    private  SuperHomePage superHomePage=new SuperHomePage();




        public ViewApplication() {
            super(new GridPane(),600,500);
            grid = (GridPane)this.getRoot();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);


            grid.setPadding(new Insets(25.0, 25, 25. , 25.0D));

            Text title1 = new Text("Ordinary User Application");
            grid.add(title1,0,0,2,1);
            title1.setFont(Font.font("Verdana", 20.0));


            // get data of item to sell from database
            TableView userApplication = new TableView();
            TableColumn name = new TableColumn("Name");
            TableColumn userName = new TableColumn("UserName");
            TableColumn password = new TableColumn("Password");
            TableColumn address = new TableColumn(" Address");
            TableColumn phone = new TableColumn("Phone Number");
            TableColumn creditCard = new TableColumn("Phone Number");



            userApplication.getColumns().addAll(name,userName,password,address,phone,creditCard);


            grid.add(userApplication, 1,2);

            //send message to ordinary user
            Button addUser = new Button("Accept");


            Button rejectUser = new Button("Reject");


            Button home =new Button("Back");
            home.setOnAction(e-> {
                main.getPrimaryStage().setScene(superHomePage);
                main.getPrimaryStage().setTitle("Home Page");
                main.getPrimaryStage().show();


            });

            HBox allButton = new HBox(10);
            allButton.setAlignment(Pos.BOTTOM_LEFT);
            allButton.getChildren().addAll(addUser,rejectUser,home);
            grid.add(allButton,1,3);


        }

    }