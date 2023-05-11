package com.example.librarymanager;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

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

    // Other common methods or properties could go here
}