import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.geometry.Insets;

import java.util.ArrayList;
import java.util.List;

public class NotificationsPage extends Scene {

    private GridPane grid;
    private ListView<Notification> listView;
    private ObservableList<Notification> listOfNotifications;
    //private NotificationDetails notificationDetails;

    private String username;
    private Stage newStage;

    public void openWindow(){
        newStage = new Stage();
        newStage.setScene(this);
        newStage.setTitle("Notifications");
        newStage.show();
    }

    public NotificationsPage(String username){
        super(new GridPane(),300,300);
        grid = (GridPane)this.getRoot();

        String keywords = Data.getKeywordsOf(username);
        Label desiredKeywordsLabel = new Label("Desired Keywords");
        Label notificationLabel = new Label("Notifications");
        TextArea keywordsTextArea = new TextArea(keywords);
        Button saveKeywordsButton = new Button("Save Keywords");
        Button detailsButton = new Button("View Details");
        VBox keywordBox = new VBox(8);

        listOfNotifications = FXCollections.observableArrayList(Data.getNotificationsFor(username)); 
        listView = new ListView<Notification>(listOfNotifications);

        saveKeywordsButton.setOnAction(e ->{
            String newKeywords = keywordsTextArea.getText();
            Data.editKeywords(username,newKeywords);
        });

        detailsButton.setOnAction(e ->{
            Notification selectedNote = listView.getSelectionModel().getSelectedItem();
            if(selectedNote != null){
//                notificationDetails = new NotificationDetails(selectedNote);
//                notificationDetails.openWindow();

            }

        });


        keywordsTextArea.setPrefColumnCount(8);
        keywordsTextArea.setPrefRowCount(2);

        keywordBox.getChildren().addAll(desiredKeywordsLabel,keywordsTextArea, saveKeywordsButton);
        grid.add(keywordBox,0,0);
        grid.add(notificationLabel,0,1);
        grid.add(listView,0,2);
        grid.add(detailsButton,0,3);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,10,10,10));

        listView.setMinHeight(10);
        listView.setMinWidth(10);




    }




}

/*
    private List<String> messageList = new ArrayList<>();
        List<HBox> listHbox = new ArrayList<>();
        ObservableList<String> list = FXCollections.observableArrayList(Data.getNotificationsFor());
        messageList.addAll(list);
        for ( int i = 0; i < messageList.size(); i++ ) {
            HBox hbox = new HBox();
            Label label = new Label(messageList.get(i));
            Button openBtn = new Button("Open");
            hbox.getChildren().addAll(label, openBtn);
            listHbox.add(hbox);

            openBtn.setOnAction(( e -> {
                System.out.println("Open Worked");
            }));
        }
        ObservableList<HBox> myObservableList = FXCollections.observableList(listHbox);
        listView.setItems(myObservableList);
*/