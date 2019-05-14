

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

public class ViewApplication extends Application{



        public void start(Stage primaryStage) {
            primaryStage.setTitle("Super User");
            GridPane applicationGrid = new GridPane();
            applicationGrid.setAlignment(Pos.CENTER);
            applicationGrid.setHgap(10);
            applicationGrid.setVgap(10);
            applicationGrid.setPadding(new Insets(25.0, 25, 25. , 25.0D));
            Scene scene = new Scene(applicationGrid, 400, 400);
            Text title1 = new Text("Ordinary User Application");
            applicationGrid.add(title1,0,0,2,1);
            title1.setFont(Font.font("Verdana", 20.0));


            // get data of item to sell from database
            TableView userApplication = new TableView();
            TableColumn name = new TableColumn("Name");
            TableColumn address = new TableColumn(" Address");
            TableColumn phone = new TableColumn("Phone Number");
            TableColumn creditCard = new TableColumn("Phone Number");



            userApplication.getColumns().addAll(name,address,phone,creditCard);


            applicationGrid.add(userApplication, 1,2);

            //send message to ordinary user
            Button addUser = new Button("Accept");


            Button rejectUser = new Button("Reject");


            Button home =new Button("Back");
            home.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    SuperHomePage home = new SuperHomePage();
                    //home.start(primaryStage);

                }
            });

            HBox allButton = new HBox(10);
            allButton.setAlignment(Pos.BOTTOM_LEFT);
            allButton.getChildren().addAll(addUser,rejectUser,home);
            applicationGrid.add(allButton,1,3);

            primaryStage.setScene(scene);
            primaryStage.show();
        }

    }