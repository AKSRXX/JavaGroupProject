package com.it3330.librarymanager;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class EmployeeController extends BaseController{
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
        String title = titleField.getText();
        Date date1 = java.util.Date.from(
                date
                        .atStartOfDay(                       // Let java.time determine the first moment of the day on that date in that zone. Never assume the day starts at 00:00:00.
                                ZoneId.of( "America/Montreal" )  // Specify time zone using proper name in `continent/region` format, never 3-4 letter pseudo-zones such as “PST”, “CST”, “IST”.
                        )                                    // Produce a `ZonedDateTime` object.
                        .toInstant()                         // Extract an `Instant` object, a moment always in UTC.
        );
        System.out.println(String.format("[New Employee] Name: %s Address: %s Email: %s, SSN: %s, Date: %s, Employee Title: %s", name, address, email, SSN, date, title));
        Member member = new Member(name, address, date1, email, new SSN(SSN));
        member.saveTo("db.txt");
        System.out.println(member.getMemberId());
    }
    private String formatString(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String formattedDate = date.format(formatter);
        return formattedDate;
    }
}
