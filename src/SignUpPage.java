import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SignUpPage extends Scene {

    GridPane grid;
    private Main main = new Main();
    private static LoginPage loginpage = new LoginPage();


    public SignUpPage() {
        super(new GridPane(),390,300);
        grid = (GridPane)this.getRoot();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        Text scenetitle = new Text("SignUp Page");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label fullName = new Label("Full Name:");
        grid.add(fullName, 0, 1);

        TextField fullNameTextField = new TextField();
        grid.add(fullNameTextField , 1, 1);

        Label userName = new Label("Username:");
        grid.add(userName, 0, 2);

        TextField userNameTextField = new TextField();
        grid.add(userNameTextField, 1, 2);

        Label passWord = new Label("Password:");
        grid.add(passWord, 0, 3);

        TextField passWordTextField = new TextField();
        grid.add(passWordTextField, 1, 3);

        Label address = new Label("Address:");
        grid.add(address, 0, 4);

        TextField addressTextField = new TextField();
        grid.add(addressTextField, 1, 4);

        Label phoneNu = new Label("Phone Number:");
        grid.add(phoneNu, 0, 5);

        TextField phoneNuTextField = new TextField();
        grid.add(phoneNuTextField, 1, 5);

        Label creditCard = new Label("Credit Card #:");
        grid.add(creditCard, 0, 6);

        TextField creditCardTextField = new TextField();
        grid.add(creditCardTextField, 1, 6);

        Button backtologin = new Button("Back");
        HBox backbtn = new HBox(10);
        backbtn.setAlignment(Pos.BOTTOM_LEFT);
        backbtn.getChildren().add(backtologin);
        grid.add(backtologin, 0, 7);

        Button signup = new Button("Sign Up");
        HBox signupbtn = new HBox(10);
        signupbtn.setAlignment(Pos.BASELINE_RIGHT);
        signupbtn.getChildren().add(signup);
        grid.add(signup, 1, 7);

        // Connect to database, add new user
        signup.setOnAction( e -> {
//            main.getPrimaryStage().setScene(loginpage);
//            main.getPrimaryStage().setTitle("Login Page");
//            main.getPrimaryStage().show();
            AlertBox.display("Signup Popup", "Your application was sent to the Super User!");

        });

        // Leave alone
        backtologin.setOnAction( e -> {
            main.getPrimaryStage().setScene(loginpage);
            main.getPrimaryStage().setTitle("Login Page");
            main.getPrimaryStage().show();
        });

    }
}
