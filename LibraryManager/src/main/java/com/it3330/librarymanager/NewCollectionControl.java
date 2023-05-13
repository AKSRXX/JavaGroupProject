package com.it3330.librarymanager;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class NewCollectionControl extends BaseController {
    @FXML
    private TextField collectionField;
    @FXML
    protected void saveButton() throws Exception {
        System.out.println(collectionField.getText());
        EventHandlerMain.newCollectionEvent(collectionField.getText());

    }
    @FXML
    private void clear()throws Exception{
        super.clearControllerProperties(this);
    }
}
