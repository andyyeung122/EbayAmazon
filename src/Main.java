import javafx.application.*;
import javafx.stage.*;


public class Main extends Application{

    private GuestHomePage guesthomepage;
    private static Stage primaryStage;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String username = "";


    public static void Main(String [] args){
        launch(args);
    }

    @Override
    public void start(Stage stage){
        primaryStage = stage;
        guesthomepage = new GuestHomePage();
        stage.setScene(guesthomepage);

        stage.setTitle("Guest Home Page");
        stage.show();
        
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}
