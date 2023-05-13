package com.it3330.librarymanager;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RemoveMemberController extends BaseController{
    @FXML
    private TextField SSNField;
    public String addDashes(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.insert(3, '-');
        sb.insert(6, '-');
        return sb.toString();
    }
    @FXML
    private void clear()throws Exception{
        super.clearControllerProperties(this);
    }
    @FXML
    protected void saveButton() throws IOException {
        System.out.println(this.addDashes(SSNField.getText()));
        EventHandlerMain.newRemoveMemberEvent(this.addDashes(SSNField.getText()));
    }
}
