import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class FriendsPage extends Scene {

    GridPane grid;
    private OrdHomePage ordhomepage;
    private String username;
    private Stage primaryStage;
    private ListView<String> friendsListView;
    private ListView<String> requestsListView;
    FriendsPage refreshedPage;

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    private void refreshPage(){
        refreshedPage = new FriendsPage(username);
        refreshedPage.setPrimaryStage(primaryStage);
        primaryStage.setTitle("Friends");
        primaryStage.setScene(refreshedPage);
    }

    public FriendsPage(String username) {
        super(new GridPane(),400,500);
        this.username = username;
        grid = (GridPane)this.getRoot();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,10,10,10));

        Text scenetitle = new Text("Friends");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        grid.add(scenetitle, 0, 0, 2, 1);

        ObservableList<String> listOfFriends = FXCollections.observableArrayList(Data.getFriendsOf(username));
        friendsListView = new ListView<>(listOfFriends);
        grid.add(friendsListView,0,1);

        Text friendRequestsTitle = new Text("Friend Requests");
        friendRequestsTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        grid.add(friendRequestsTitle, 0, 2, 2, 1);

        ObservableList<String> listOfRequests = FXCollections.observableArrayList(Data.getFriendRequestsOf(username));
        requestsListView = new ListView<>(listOfRequests);
        grid.add(requestsListView,0,3);

        Button acceptRequestBttn = new Button("Accept");
        Button rejectRequestBttn = new Button("Reject");

        HBox requestBox = new HBox(8);
        requestBox.getChildren().addAll(acceptRequestBttn,rejectRequestBttn);
        grid.add(requestBox,0,4);

        VBox friendBox = new VBox(15);

        Button addFriend = new Button("Add Friend");
        Button deleteFriend = new Button("Delete");
        Button sendMessage = new Button("Send Message");
        friendBox.getChildren().addAll(addFriend,deleteFriend,sendMessage);
        grid.add(friendBox,1,1);

        Button backBtn = new Button("Back");
        grid.add(backBtn, 0,5);

        acceptRequestBttn.setOnAction(e->{
            String potentialFriend = requestsListView.getSelectionModel().getSelectedItem();
            if(potentialFriend!=null){
                Data.createFriend(username,potentialFriend);
                Data.deleteFriendRequest(potentialFriend,username);
                refreshPage();
            }
        });

        rejectRequestBttn.setOnAction(e->{
            String potentialFriend = requestsListView.getSelectionModel().getSelectedItem();
            if(potentialFriend != null){
                Data.deleteFriendRequest(potentialFriend,username);
                refreshPage();
            }
        });

        backBtn.setOnAction( e -> {
            ordhomepage = new OrdHomePage();
            ordhomepage.setUsername(username);
            ordhomepage.setPrimaryStage(primaryStage);
            primaryStage.setScene(ordhomepage);
            primaryStage.setTitle("Home Page");
            primaryStage.show();
        });

        deleteFriend.setOnAction(( e -> {
            GridPane deletegrid = new GridPane();
            deletegrid.setHgap(10);
            deletegrid.setVgap(10);
            Scene scene = new Scene(deletegrid, 350,100);
            Stage window = new Stage();
            Text title = new Text("Are you sure you want to delete this friend?");
            title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            deletegrid.add(title, 0, 0, 2, 1);

            Button deleteFriend2 = new Button("Delete");
            deletegrid.add(deleteFriend2, 0, 1);

            Button back2 = new Button("Back");
            deletegrid.add(back2,2,1);

            deleteFriend2.setOnAction(el->{
                String friendUsername = friendsListView.getSelectionModel().getSelectedItem();
                if(friendUsername!=null){
                    Data.deleteFriend(username,friendUsername);
                    refreshPage();
                    window.close();
                }
            });

            back2.setOnAction(( el -> {
                window.close();
            }));

            window.setTitle("Delete Friend");
            window.setScene(scene);
            window.show();

        }));

        addFriend.setOnAction(( e -> {
            GridPane addgrid = new GridPane();
            addgrid.setHgap(10);
            addgrid.setVgap(10);
            Scene scene2 = new Scene(addgrid, 350,100);
            Stage window2 = new Stage();
            Text title2 = new Text("Add Friend");
            title2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            addgrid.add(title2, 0, 0, 2, 1);

            Text usernameText = new Text("Username: ");
            addgrid.add(usernameText, 0,1);

            TextField usernameField = new TextField();
            addgrid.add(usernameField, 1, 1);

            Button addFriend2 = new Button("Add");
            addgrid.add(addFriend2, 0, 2);

            Button back3 = new Button("Back");
            addgrid.add(back3,2,2);

            window2.setTitle("Add Friend");
            window2.setScene(scene2);
            window2.show();
            
            addFriend2.setOnAction(el ->{
                String potentialFriend = usernameField.getText();
                if(!potentialFriend.equals("")){
                    Data.createFriendRequest(username,potentialFriend);
                    window2.close();
                }
            });

            back3.setOnAction(( el -> {
                window2.close();
            }));
        }));

        sendMessage.setOnAction(( e -> {

            GridPane messagegrid = new GridPane();
            messagegrid.setHgap(10);
            messagegrid.setVgap(10);
            Scene scene3 = new Scene(messagegrid, 250,200);
            Stage window3 = new Stage();
            Text title3 = new Text("Send Message");
            title3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            messagegrid.add(title3, 0, 0, 2, 1);

            Text message = new Text("Message: ");
            messagegrid.add(message, 0,1);

            TextArea messageField = new TextArea();
            messageField.setPrefColumnCount(10);
            messageField.setWrapText(true);     // New line of the text exceeds the text area
            messageField.setPrefRowCount(5);
            messagegrid.add(messageField, 1, 1);

            Button sendMessageBttn = new Button("Send");
            messagegrid.add(sendMessageBttn, 0, 2);

            Button back3 = new Button("Back");
            messagegrid.add(back3,1,2);

            window3.setTitle("Send Message");
            window3.setScene(scene3);
            window3.show();

            sendMessageBttn.setOnAction(el->{
                String messageContents = messageField.getText();
                String friendUsername = friendsListView.getSelectionModel().getSelectedItem();
                if(friendUsername!=null && !messageContents.equals("")){
                    Data.sendFriendMessage(username,friendUsername,messageContents);
                    window3.close();
                }
            });

            back3.setOnAction(( el -> {
                window3.close();
            }));
        }));

    }
}
