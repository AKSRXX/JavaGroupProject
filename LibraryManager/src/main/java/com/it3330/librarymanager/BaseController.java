package com.it3330.librarymanager;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Field;

public class BaseController {

    @FXML
    private Button homeBtn;

    @FXML
    void handleHome(ActionEvent event) throws IOException {
        Parent menuParent = FXMLLoader.load(HelloApplication.class.getResource("MainMenu2.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }
    @FXML
    public void clearControllerProperties(Object controller) {
        Field[] fields = controller.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object property = field.get(controller);
                if (property instanceof TextField) {
                    ((TextField) property).clear();
                } else if (property instanceof DatePicker) {
                    ((DatePicker) property).setValue(null);
                } else if (property instanceof ComboBox) {
                    ((ComboBox) property).getSelectionModel().clearSelection();
                }
                // add more else if statements here for other control types
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    // Other common methods or properties could go here
}