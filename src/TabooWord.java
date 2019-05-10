import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TabooWord extends Application {
    private final ObservableList<TabooWord.WordList> WordsList = FXCollections.observableArrayList(new TabooWord.WordList[]{new TabooWord.WordList("CCNY"), new TabooWord.WordList("New York"), new TabooWord.WordList("Computer Science")});
    private int selectedIndex = -1;

    public TabooWord() {
    }

    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Ebay Amazon");
        stage.setWidth(400);
        stage.setHeight(600);
        Label nameLabel = new Label("Taboo Words");
        nameLabel.setFont(new Font("Roman", 20));
        TextField nameTxt = new TextField();
        nameTxt.setPromptText("Name");
        ListView myListView = new ListView();
        myListView.setItems(this.WordsList);
        myListView.setOnMouseClicked((event) -> {
            this.selectedIndex = myListView.getSelectionModel().getSelectedIndex();

        });
        Button add = new Button("Add");
        add.setOnAction((e) -> {
            this.WordsList.add(new TabooWord.WordList(nameTxt.getText()));
            nameTxt.clear();
        });
        Button delete= new Button("Delete");
        delete.setOnAction((e) -> {
            this.WordsList.remove(this.selectedIndex);
            nameTxt.clear();
        });
        HBox myHBox = new HBox();
        myHBox.getChildren().addAll(new Node[]{nameTxt, add, delete});
        myHBox.setSpacing(3.0D);
        VBox myVBox = new VBox();
        myVBox.setSpacing(5.0D);
        myVBox.setPadding(new Insets(10.0D, 0.0D, 0.0D, 10.0D));
        myVBox.getChildren().addAll(new Node[]{nameLabel, myListView, myHBox});
        ((Group)scene.getRoot()).getChildren().addAll(new Node[]{myVBox});
        stage.setScene(scene);
        stage.show();
    }


    public static class WordList {
        private final SimpleStringProperty name;

        private WordList(String name) {
            this.name = new SimpleStringProperty(name);
        }

        public String getName() {
            return this.name.get();
        }


        public String toString() {
            return this.getName();
        }
    }
}
