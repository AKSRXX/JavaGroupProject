import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class GUIMain extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Views/MainMenu2.fxml"));
        VBox root = loader.load();

        // ListView<Book> listView = (ListView<Book>) loader.getNamespace().get("your_listview_id");

        // ObservableList<Book> overdueBooks = FXCollections.observableArrayList(
        //         new Book("Book 1", "Author 1", LocalDate.now().minusDays(1)),
        //         new Book("Book 2", "Author 2", LocalDate.now().minusDays(3)),
        //         new Book("Book 3", "Author 3", LocalDate.now().minusDays(5))
        // );

        // listView.setItems(overdueBooks);

        primaryStage.setTitle("Overdue Books");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}