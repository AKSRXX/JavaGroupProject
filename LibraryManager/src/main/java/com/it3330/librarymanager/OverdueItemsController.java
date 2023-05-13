package com.it3330.librarymanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class OverdueItemsController extends BaseController {
    @FXML
    private TextField memberField;
    @FXML
    private DatePicker dueDate  ;
    @FXML
    private ListView<String> overdueView;
    @FXML
    protected void checkButton() throws Exception {
        System.out.println("[Checking Overdue] " + memberField.getText() + " " + this.formatDate(dueDate.getValue()));
        ArrayList<String> overdue_items = EventHandlerMain.newCheckOverdues(memberField.getText(), this.formatDate(dueDate.getValue()));
        System.out.println("[Found Overdue Items] " + overdue_items.toString());
        ObservableList<String> items = FXCollections.observableArrayList(overdue_items);
        overdueView.setItems(items);
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
