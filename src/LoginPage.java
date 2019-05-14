import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginPage extends Scene {
    Data data=new Data();

    GridPane grid;
    private Main main = new Main();
    private static AlertBox alertbox = new AlertBox();
    private  SuperHomePage superHomePage=new SuperHomePage();
    private static SignUpPage signuppage = new SignUpPage();
    private static OrdHomePage ordhomepage = new OrdHomePage();
    private static GuestHomePage guesthomepage = new GuestHomePage();

    public LoginPage() {

        super(new GridPane(),390,200);
        grid = (GridPane)this.getRoot();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);



        Text scenetitle = new Text("Login Page");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Username:");
        grid.add(userName, 0, 1);

        TextField userNameTextField = new TextField();
        grid.add(userNameTextField, 1, 1);

        Label passWord = new Label("Password:");
        grid.add(passWord, 0, 2);

        PasswordField passWordTextField = new PasswordField();
        grid.add(passWordTextField, 1, 2);

        Button login = new Button("Log in");
        HBox loginBtn = new HBox(10);
        loginBtn.setAlignment(Pos.BOTTOM_RIGHT);
        loginBtn.getChildren().add(login);
        grid.add(loginBtn, 1, 4);

        Button signup = new Button("Sign Up");
        HBox signupbtn = new HBox(10);
        signupbtn.setAlignment(Pos.BOTTOM_LEFT);
        signupbtn.getChildren().add(signup);
        grid.add(signup, 0, 4);

        Button back = new Button("Back");
        HBox backbtn = new HBox(10);
        backbtn.setAlignment(Pos.BOTTOM_RIGHT);
        backbtn.getChildren().add(back);
        grid.add(backbtn, 1, 5);

        // Connect to Database
        signup.setOnAction( e -> {
            main.getPrimaryStage().setScene(signuppage);
            main.getPrimaryStage().setTitle("SignUp Page");
            main.getPrimaryStage().show();
        });

        // Connect to Database
        login.setOnAction( e -> {
<<<<<<< HEAD
            if(!data.isSuperUser(userNameTextField.getText(),passWordTextField.getText())&&data.isOrdinairyUser(userNameTextField.getText(),passWordTextField.getText())) {
                main.setUsername(userNameTextField.getText());
=======
            if(!data.isSuperUser(userNameTextField.getText(),passWordTextField.getText())&&data.isOrdinairyUser(userNameTextField.getText(),passWordTextField.getText())&&data.isRegisteredUser(userNameTextField.getText())==true) {
>>>>>>> 77b5efe132bcced2e5fe90ab6bd3d01442c09b44
                main.getPrimaryStage().setScene(ordhomepage);
                main.getPrimaryStage().setTitle("Home Page");
                main.getPrimaryStage().show();
            }
            else if(data.isSuperUser(userNameTextField.getText(),passWordTextField.getText())){
                main.setUsername(userNameTextField.getText());
                main.getPrimaryStage().setScene(superHomePage);
                main.getPrimaryStage().setTitle("Home Page");
                main.getPrimaryStage().show();
            }

            else{
                alertbox.display("Signup Popup", "User doesn't exist or password is wrong!");
            }



        });

        back.setOnAction(( e -> {
            main.getPrimaryStage().setScene(guesthomepage);
            main.getPrimaryStage().setTitle("Guest Home Page");
            main.getPrimaryStage().show();
        }));

    }

}
