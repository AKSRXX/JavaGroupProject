package com.it3330.librarymanager;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class EditMemberController extends BaseController{
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private TextField nameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField SSNField;
    @FXML
    private DatePicker dateField;
    @FXML
    private TextField titleField;


    @FXML
    private void getValues() throws Exception {
        String name = nameField.getText();
        String address = addressField.getText();
        String email = emailField.getText();
        String SSN = SSNField.getText();
        LocalDate date= dateField.getValue();
        String type = choiceBox.getValue();
        Date date1 = Date.from(
                date
                        .atStartOfDay(                       // Let java.time determine the first moment of the day on that date in that zone. Never assume the day starts at 00:00:00.
                                ZoneId.of( "America/Montreal" )  // Specify time zone using proper name in `continent/region` format, never 3-4 letter pseudo-zones such as “PST”, “CST”, “IST”.
                        )                                    // Produce a `ZonedDateTime` object.
                        .toInstant()                         // Extract an `Instant` object, a moment always in UTC.
        );
        System.out.println(String.format("[Edited Member] Name: %s Address: %s Email: %s, SSN: %s, Date: %s, Member Type: %s", name, address, email, SSN, date, type));
        EventHandlerMain.newRemoveMemberEvent(this.addDashes(SSN));
        EventHandlerMain.newMemberEvent(name, address, date1, email, SSN, type);
    }
    @FXML
    private void clear()throws Exception{
        super.clearControllerProperties(this);
    }
    public String addDashes(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.insert(3, '-');
        sb.insert(6, '-');
        return sb.toString();
    }
    private String formatString(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formattedDate = date.format(formatter);
        return formattedDate;
    }
}
