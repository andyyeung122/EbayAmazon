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

public class TabooWord extends Scene {
    private final ObservableList<TabooWord.WordList> WordsList = FXCollections.observableArrayList(new TabooWord.WordList[]{new TabooWord.WordList("CCNY"), new TabooWord.WordList("New York"), new TabooWord.WordList("Computer Science")});
    private int selectedIndex = -1;
    GridPane grid;
    private Main main = new Main();
    private Stage primaryStage;;
    private  SuperHomePage superhomepage;
    private Data data = new Data();

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public TabooWord() {
        super(new GridPane(),390,300);
        grid = (GridPane)this.getRoot();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        Text title = new Text("Taboo Words");
        grid.add(title,0,0,2,1);
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

        grid.add(myListView, 1,2);

        Button add = new Button("Add");
        add.setOnAction((e) -> {

           // data.createTabooWord(this.selectedIndex);
            nameTxt.clear();
        });
        Button delete= new Button("Delete");
        delete.setOnAction((e) -> {
            this.WordsList.remove(this.selectedIndex);
            nameTxt.clear();
        });

        Button back = new Button("Back");
        back.setOnAction(e-> {
            superhomepage = new SuperHomePage();
            superhomepage.setPrimaryStage(primaryStage );
            primaryStage.setScene(superhomepage);
            primaryStage.setTitle("Home Page");
            primaryStage.show();
        });

        HBox allButton = new HBox(10);
        allButton.setAlignment(Pos.BOTTOM_LEFT);
        allButton.getChildren().addAll(add,delete,back);
        grid.add(allButton,1,4);


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
