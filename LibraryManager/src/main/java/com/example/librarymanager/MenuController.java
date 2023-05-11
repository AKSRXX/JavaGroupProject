package com.example.librarymanager;

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
    void handleNewCollectionClick(ActionEvent event) {
        System.out.println("New Collection button clicked!");
    }

    @FXML
    void handleRemoveMembershipClick(ActionEvent event) {
        System.out.println("Remove Membership button clicked!");
    }

    @FXML
    void handleNewEmployeeClick(ActionEvent event) {
        System.out.println("New Employee button clicked!");
    }

    @FXML
    void handleBorrowItemClick(ActionEvent event) {
        System.out.println("Borrow Item button clicked!");
    }

    @FXML
    void handleReturnItemClick(ActionEvent event) {
        System.out.println("Return Item button clicked!");
    }

    @FXML
    void handleCheckOverduesClick(ActionEvent event) {
        System.out.println("Check Overdues button clicked!");
    }

    @FXML
    void handleEditInformationClick(ActionEvent event) {
        System.out.println("Edit Information button clicked!");
    }

    @FXML
    void handleRemoveItemClick(ActionEvent event) {
        System.out.println("Remove Item From Collection button clicked!");
    }

    @FXML
    void handleQuitClick(ActionEvent event) {
        System.out.println("Quit button clicked!");
    }
}
