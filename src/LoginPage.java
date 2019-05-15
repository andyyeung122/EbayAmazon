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
    public Stage primaryStage;
    private static AlertBox alertbox = new AlertBox();
    private  SuperHomePage superHomePage;
    private static SignUpPage signuppage;
    private static OrdHomePage ordhomepage;
    private static GuestHomePage guesthomepage;
    private static ItemsBox itemsbox;
    public String accusername = "";

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

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
            signuppage = new SignUpPage();
            signuppage.setPrimaryStage(primaryStage);
            primaryStage.setScene(signuppage);
            primaryStage.setTitle("SignUp Page");
            primaryStage.show();
        });

        // Connect to Database
        login.setOnAction( e -> {

                    accusername = userNameTextField.getText();
                    String accuserpassword = passWordTextField.getText();
                    if (data.isSuperUser(accusername, accuserpassword)) {
                        superHomePage = new SuperHomePage();
                        superHomePage.setUsername(accusername);
                        primaryStage.setScene(superHomePage);
                        primaryStage.setTitle("Home Page");
                        primaryStage.show();
                    } else if (data.isOrdinairyUser(accusername, accuserpassword)) {
                        ordhomepage = new OrdHomePage();
                        ordhomepage.setUsername(accusername);
                        ordhomepage.setPassword(accuserpassword);
                        ordhomepage.setPrimaryStage(primaryStage);
                        primaryStage.setScene(ordhomepage);
                        primaryStage.setTitle("Home Page");
                        primaryStage.show();
                    }

//            if(!data.isSuperUser(accusername,accuserpassword)&&data.isOrdinairyUser(userNameTextField.getText(),passWordTextField.getText())&&data.isRegisteredUser(userNameTextField.getText())==true) {
//                ordhomepage.setUsername(accusername);
//                main.getPrimaryStage().setScene(ordhomepage);
//                main.getPrimaryStage().setTitle("Home Page");
//                main.getPrimaryStage().show();
//            }

                    else {
                        alertbox.display("Signup Popup", "User doesn't exist or password is wrong!");
                    }
                }



        );

        back.setOnAction(( e -> {
            guesthomepage = new GuestHomePage();
            guesthomepage.setPrimaryStage(primaryStage);
            primaryStage.setScene(guesthomepage);
            primaryStage.setTitle("Guest Home Page");
            primaryStage.show();
        }));

    }


}
