package com.it3330.librarymanager;
import javafx.event.ActionEvent;
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
public class BorrowItemController extends BaseController{
    @FXML
    private TextField memberField;
    @FXML
    private TextField idField;
    @FXML
    private DatePicker borrowDate;
    @FXML
    private DatePicker dueDate;
    @FXML
    protected void saveButton() throws Exception {
        System.out.println("[New Borrow Event] " + memberField.getText() + idField.getText() + this.formatDate(borrowDate.getValue())+ this.formatDate(dueDate.getValue()));
        EventHandlerMain.newBorrowsEvent(memberField.getText(), idField.getText(), this.formatDate(borrowDate.getValue()), this.formatDate(dueDate.getValue()));

    }
    private String formatDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = date.format(formatter);
        System.out.println("[Converted Date] :" + dateString);
        return dateString;
    }

    public void clear(ActionEvent actionEvent) {

    }
}
