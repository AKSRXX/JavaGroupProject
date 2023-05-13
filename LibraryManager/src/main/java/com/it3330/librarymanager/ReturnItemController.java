package com.it3330.librarymanager;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class ReturnItemController extends BaseController{
    @FXML
    private TextField memberField;
    @FXML
    private TextField idField;
    @FXML
    protected void saveButton() throws Exception {
        System.out.println("[New Return Event] " + memberField.getText() + idField.getText() );
        EventHandlerMain.newReturnEvent("borrows.txt", idField.getText());
    }
    @FXML
    private void clear()throws Exception{
        super.clearControllerProperties(this);
    }
    private String formatDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = date.format(formatter);
        System.out.println("[Converted Date] :" + dateString);
        return dateString;
    }
}
