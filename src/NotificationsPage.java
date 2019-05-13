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
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

public class NotificationsPage extends Scene {

    GridPane grid;
    ListView<HBox> listView;
    private List<String> messageList = new ArrayList<>();
    private static Stage window = new Stage();



    public NotificationsPage(){

        super(new ListView<HBox>(),600,300);
        listView = (ListView)this.getRoot();
        listView.setMinHeight(10);
        listView.setMinWidth(10);
        List<HBox> listHbox = new ArrayList<>();

        ObservableList<String> list = FXCollections.observableArrayList(
                "Item 1", "Item 2", "Item 3", "Item 4");
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
    }

    public static Stage setWindow() {
        return window;
    }


}