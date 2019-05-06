import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.List;
import java.util.ArrayList;

public class OrdHomePage extends GuestHomePage{

    private boolean isVIP = true;


    public OrdHomePage() {
        super();

        if (isVIP) {
            Text VIP = new Text("VIP");
            VIP.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
            VIP.setFill(Color.RED);
            grid.add(VIP, 1, 0, 2,1);
        }

        Button sellItem = new Button("Sell Items");
        HBox sellBtn = new HBox(10);
        sellBtn.setAlignment(Pos.TOP_RIGHT);
        sellBtn.getChildren().add(sellItem);
        grid.add(sellBtn, 4, 2);

        Button manage = new Button("Manage Items");
        HBox manageBtn = new HBox(10);
        manageBtn.setAlignment(Pos.TOP_RIGHT);
        manageBtn.getChildren().add(manage);
        grid.add(manageBtn, 4, 3);

        Button submitComplaint = new Button("Submit Complaint");
        HBox submitComplaintBtn = new HBox(10);
        submitComplaintBtn.setAlignment(Pos.TOP_RIGHT);
        submitComplaintBtn.getChildren().add(submitComplaint);
        grid.add(submitComplaintBtn, 4, 5);

        Button editProfile = new Button("Edit Profile");
        HBox editProfileBtn = new HBox(10);
        editProfileBtn.setAlignment(Pos.TOP_RIGHT);
        editProfileBtn.getChildren().add(editProfile);
        grid.add(editProfileBtn, 4, 1);

        Button friends = new Button("Friends");
        HBox friendsBtn = new HBox(10);
        friendsBtn.setAlignment(Pos.TOP_RIGHT);
        friendsBtn.getChildren().add(friends);
        grid.add(friendsBtn, 4, 6);

        Button history = new Button("Transaction History");
        HBox historyBtn = new HBox(10);
        historyBtn.setAlignment(Pos.TOP_RIGHT);
        historyBtn.getChildren().add(history);
        grid.add(historyBtn, 4, 4);

        Button inbox = new Button("Inbox");
        HBox inboxBtn = new HBox(10);
        inboxBtn.setAlignment(Pos.TOP_RIGHT);
        inboxBtn.getChildren().add(inbox);
        grid.add(inboxBtn, 4, 7);



        manage.setOnAction( e -> {

        });
    }
    
}
