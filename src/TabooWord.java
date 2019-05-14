import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TabooWord extends Application {
    private final ObservableList<TabooWord.WordList> WordsList = FXCollections.observableArrayList(new TabooWord.WordList[]{new TabooWord.WordList("CCNY"), new TabooWord.WordList("New York"), new TabooWord.WordList("Computer Science")});
    private int selectedIndex = -1;

    public TabooWord() {
    }

    public void start(Stage primaryStage) {

        primaryStage.setTitle("Ebay Amazon");
        GridPane tabooGrid = new GridPane();
        tabooGrid.setAlignment(Pos.CENTER);
        tabooGrid.setHgap(10);
        tabooGrid.setVgap(10.D);
        tabooGrid.setPadding(new Insets(25.0D, 25.0D, 25.0D, 25.0D));
        Scene scene = new Scene(tabooGrid, 400, 400);
        Text title = new Text("Taboo Words");
        tabooGrid.add(title,0,0,2,1);
        title.setFont(Font.font("Verdana", 20.0D));
        Label nameLabel = new Label("Taboo Words");
        nameLabel.setFont(new Font("Roman", 20));
        TextField nameTxt = new TextField();
        nameTxt.setPromptText("Name");
        ListView myListView = new ListView();
        myListView.setItems(this.WordsList);
        myListView.setOnMouseClicked((event) -> {
            this.selectedIndex = myListView.getSelectionModel().getSelectedIndex();

        });

        tabooGrid.add(myListView, 1,2);

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

        Button back = new Button("Back");
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                SuperHomePage sh = new SuperHomePage();
                sh.start(primaryStage);

            }
        });

        HBox allButton = new HBox(10);
        allButton.setAlignment(Pos.BOTTOM_LEFT);
        allButton.getChildren().addAll(add,delete,back);
        tabooGrid.add(allButton,1,4);

        primaryStage.setScene(scene);
        primaryStage.show();
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
