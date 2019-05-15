import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class NotificationDetails extends Scene{

    private Stage newStage;

    public void openWindow(){
        newStage = new Stage();
        newStage.setScene(this);
        newStage.setTitle("Notification Details");
        newStage.show();
    }
    
    public NotificationDetails(Notification note){
        super(new GridPane(),1000,100);
        GridPane grid = (GridPane)this.getRoot();

        Label titleLabel = new Label("Title:");
        Label messageLabel = new Label("Message:");
        Label titelContentLabel = new Label(note.getTitle());
        Label messageContentLabel = new Label(note.getMessage());
        HBox titleBox = new HBox(5,titleLabel,titelContentLabel);
        HBox messageBox = new HBox(5,messageLabel,messageContentLabel);

        grid.add(titleBox,0,0);
        grid.add(messageBox,0,1);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,10,10,10));

    }
}