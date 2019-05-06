import javafx.application.*;
import javafx.stage.*;


public class Main extends Application{

    private LoginPage loginpage;
    private SubGuestHomePage guesthomepage;
    private static Stage primaryStage;


    public static void Main(String [] args){
        launch(args);
    }

    @Override
    public void start(Stage stage){
        primaryStage = stage;
        guesthomepage = new SubGuestHomePage();
        stage.setScene(guesthomepage);

        stage.setTitle("Guest Home Page");
        stage.show();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}
