import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class SubGuestHomePage extends GuestHomePage {

    private static LoginPage loginpage2 = new LoginPage();
    private static Main main = new Main();

    public SubGuestHomePage() {
        super();

        Button login = new Button("Log in");
        HBox loginBtn = new HBox(10);
        loginBtn.setAlignment(Pos.TOP_RIGHT);
        loginBtn.getChildren().add(login);
        grid.add(loginBtn, 5, 0);

        login.setOnAction( e -> {
            main.getPrimaryStage().setScene(loginpage2);
            main.getPrimaryStage().setTitle("Guest Home Page");
            main.getPrimaryStage().show();
        });


    }

}

