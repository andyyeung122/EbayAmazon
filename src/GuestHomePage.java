import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GuestHomePage extends Scene {

    GridPane grid;
    private static LoginPage loginpage2 = new LoginPage();
    Main main = new Main();


    public GuestHomePage() {
        super(new GridPane(),600,600);
        grid = (GridPane)this.getRoot();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        Text scenetitle = new Text("Ebay-Amazon");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        TextField searchTextField = new TextField();
        searchTextField.setPromptText("Search");
        grid.add(searchTextField, 0, 1);

        Button login = new Button("Log in");
        HBox loginBtn = new HBox(10);
        loginBtn.setAlignment(Pos.TOP_RIGHT);
        loginBtn.getChildren().add(login);
        grid.add(loginBtn, 2, 1);

        Button search = new Button("Search");
        HBox searchBtn = new HBox(10);
        searchBtn.getChildren().add(search);
        grid.add(searchBtn, 1, 1);

        // Link to DB
        login.setOnAction( e -> {
            main.getPrimaryStage().setScene(loginpage2);
            main.getPrimaryStage().setTitle("Guest Home Page");
            main.getPrimaryStage().show();
        });

        search.setOnAction( e -> {
//            main.getPrimaryStage().setScene(loginpage2);
//            main.getPrimaryStage().setTitle("Home Page");
//            main.getPrimaryStage().show();
        });
    }
}
