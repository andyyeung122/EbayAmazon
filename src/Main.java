import javafx.application.*;
import javafx.stage.*;


public class Main extends Application{

    private LoginPage loginpage;
    private static Stage primaryStage;


    public static void main(String [] args){
        launch(args);
    }

    @Override
    public void start(Stage stage){
        primaryStage = stage;
        loginpage = new LoginPage();
        stage.setScene(loginpage);

        stage.setTitle("Login Page");
        stage.show();

    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}
