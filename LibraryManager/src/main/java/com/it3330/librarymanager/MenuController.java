package com.it3330.librarymanager;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class MenuController {

    @FXML
    private Button newMembershipBtn;

    @FXML
    private Button newCollectionBtn;

    @FXML
    private Button removeMembershipBtn;

    @FXML
    private Button newEmployeeBtn;

    @FXML
    private Button borrowItemBtn;

    @FXML
    private Button returnItemBtn;

    @FXML
    private Button checkOverduesBtn;

    @FXML
    private Button editInformationBtn;

    @FXML
    private Button removeItemBtn;

    @FXML
    private Button quitBtn;

    @FXML
    void handleNewMembershipClick(ActionEvent event) throws IOException, IOException {

        Parent menuParent = FXMLLoader.load(HelloApplication.class.getResource("AddNewMember.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    @FXML
    void handleNewCollectionClick(ActionEvent event) throws IOException {

        Parent menuParent = FXMLLoader.load(HelloApplication.class.getResource("AddNewCollection.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    @FXML
    void handleRemoveMembershipClick(ActionEvent event) throws IOException {

        Parent menuParent = FXMLLoader.load(HelloApplication.class.getResource("RemoveMember.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    @FXML
    void handleNewEmployeeClick(ActionEvent event) throws IOException {

        Parent menuParent = FXMLLoader.load(HelloApplication.class.getResource("AddNewEmployee.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    @FXML
    void handleBorrowItemClick(ActionEvent event) throws IOException {

        Parent menuParent = FXMLLoader.load(HelloApplication.class.getResource("CheckoutItem.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    @FXML
    void handleReturnItemClick(ActionEvent event) throws IOException {

        Parent menuParent = FXMLLoader.load(HelloApplication.class.getResource("ReturnItem.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    @FXML
    void handleCheckOverduesClick(ActionEvent event) throws IOException {

        Parent menuParent = FXMLLoader.load(HelloApplication.class.getResource("OverdueItems.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    @FXML
    void handleEditInformationClick(ActionEvent event) throws IOException {

        Parent menuParent = FXMLLoader.load(HelloApplication.class.getResource("EditMember.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    @FXML
    void handleRemoveItemClick(ActionEvent event) throws IOException {

        Parent menuParent = FXMLLoader.load(HelloApplication.class.getResource("RemoveCollection.fxml"));
        Scene menuScene = new Scene(menuParent);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    @FXML
    void handleQuitClick(ActionEvent event) {
        Platform.exit();
    }
}
