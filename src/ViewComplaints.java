import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class ViewComplaints  extends Application {
    public ViewComplaints() {
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle(" Super User!");
        Label title = new Label("Complaints");

        TableView compalinTable = new TableView();
        TableColumn userName =  new TableColumn();




        Button viewCompalin = new Button();
        viewCompalin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String user = userName.getText();


            }
        });

        Button back = new Button("Back");
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                SuperHomePage sh = new SuperHomePage();
                sh.start(primaryStage);

            }


        });




    }
}