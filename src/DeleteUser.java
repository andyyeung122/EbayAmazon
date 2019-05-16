import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DeleteUser extends Scene{
    GridPane grid;
    private Main main = new Main();
    private Stage primaryStage;
    private  SuperHomePage superHomePage;
    private Data data=new Data();
    TableView<User> userApplication;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public DeleteUser() {
        super(new GridPane(),1000,700);
        grid = (GridPane)this.getRoot();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
    

   
        
       
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10.0D);
        grid.setVgap(10.0D);
        grid.setPadding(new Insets(25.0D, 25.0D, 25.0D, 25.0D));

        Text title = new Text("Delete User");
        grid.add(title, 0, 0, 2, 1);
        title.setFont(Font.font("Verdana", 20.0D));
        Label userName = new Label("User Name");
        grid.add(userName, 0, 1);
        TextField userName_tf = new TextField();
        grid.add(userName_tf, 1, 1);
        Label deleteMessage = new Label("Deletion Message");
        grid.add(deleteMessage, 0, 2);
        TextField deleteMessage_tf = new TextField();
        grid.add(deleteMessage_tf, 1, 2);
        Button removeUser = new Button("Remove User");
        Button back=new Button("Back");
        HBox button = new HBox(10.0D);
        button.setAlignment(Pos.BOTTOM_RIGHT);
        button.getChildren().addAll(removeUser,back);
        grid.add(button, 1, 4);


        back.setOnAction(e-> {
            superHomePage = new SuperHomePage();
            superHomePage.setPrimaryStage(primaryStage );
            primaryStage.setScene(superHomePage);
            primaryStage.setTitle("Home Page");
            primaryStage.show();

        });

        removeUser.setOnAction(e->{
            String name=userName_tf.getText();
            data.blockUserPerm(name);


                }
                );

    }


}

