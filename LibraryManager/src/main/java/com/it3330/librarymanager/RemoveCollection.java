package com.it3330.librarymanager;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RemoveCollection extends BaseController{
    @FXML
    private TextField name;
    @FXML
    private void clear()throws Exception{
        super.clearControllerProperties(this);
    }
    @FXML
    protected void saveButton() throws IOException {
        EventHandlerMain.newReturnEvent("collections.txt", name.getText());
    }
}
