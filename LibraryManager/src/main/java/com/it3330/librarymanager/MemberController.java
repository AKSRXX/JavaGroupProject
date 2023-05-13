package com.it3330.librarymanager;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MemberController extends BaseController{
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
    private DatePicker dateField  ;


    @FXML
    private void clear()throws Exception{
        super.clearControllerProperties(this);
    }
    @FXML
    private void getValues() throws Exception {
        String name = nameField.getText();
        String address = addressField.getText();
        String email = emailField.getText();
        String SSN = SSNField.getText();
        LocalDate date= dateField.getValue();

        Date date1 = java.util.Date.from(
                date
                        .atStartOfDay(                       // Let java.time determine the first moment of the day on that date in that zone. Never assume the day starts at 00:00:00.
                                ZoneId.of( "America/Montreal" )  // Specify time zone using proper name in `continent/region` format, never 3-4 letter pseudo-zones such as “PST”, “CST”, “IST”.
                        )                                    // Produce a `ZonedDateTime` object.
                        .toInstant()                         // Extract an `Instant` object, a moment always in UTC.
        );
        System.out.printf("Name: %s Address: %s Email: %s, SSN: %s, Date: %s%n", name, address, email, SSN, date);
        Member member = new Member(name, address, date1, email, new SSN(SSN));
        EventHandlerMain.newMemberEvent(member.getName(), member.getAddress(), member.getDob(), member.getEmail(), SSN, choiceBox.getValue());
        System.out.println(member.getMemberId());
    }
    private String formatString(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formattedDate = date.format(formatter);
        return formattedDate;
    }
}
