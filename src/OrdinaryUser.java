import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OrdinaryUser extends Scene {

    private TableView table = new TableView();

    GridPane grid;
    private Main main = new Main();
    private  SuperHomePage superHomePage=new SuperHomePage();
    private Data data=new Data();
    TableView<User>review;

    public OrdinaryUser() {
        super(new GridPane(),500,400);
        grid = (GridPane)this.getRoot();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        grid.setPadding(new Insets(25.0, 25, 25. , 25.0D));

        Text title1 = new Text("Ordinary User");
        grid.add(title1,0,0,2,1);
        title1.setFont(Font.font("Verdana", 20.0));


        TableColumn<User,String> username = new TableColumn("Name");
        TableColumn<User,Integer> Rating = new TableColumn("Rating");

        review = new TableView();

        Rating.setMinWidth(100);
       review.getColumns().addAll(username,Rating);

        grid.add(review, 1,2);

         Button sendWarning = new Button("Send Warning");

         Button back=new Button("Back");
        sendWarning.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

            }
        });


         VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.setAlignment(Pos.BOTTOM_LEFT);
        vbox.getChildren().addAll(sendWarning,back);
        grid.add(vbox,1,3);


        back.setOnAction(e-> {
            main.getPrimaryStage().setScene(superHomePage);
            main.getPrimaryStage().setTitle("Home Page");
            main.getPrimaryStage().show();


        });




    }


}
