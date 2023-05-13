package com.it3330.librarymanager;

import java.util.*;
import java.io.*;
public class Employee extends Person
{
    // constructor
    String title;
    public Employee(String name, String address, Date dob, String email, SSN ssn, String title)
    {
        super(name, address, dob, email, ssn);
        this.title = title;
    }

    public void saveTo ( String textFile) throws Exception{
        FileWriter fileWriter = new FileWriter(textFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // Write the new collection to the file
        String str = getName() + ", " + getAddress() + ", " + getDob() + ", " + getEmail() + ", " + getSsn().getFormattedSSN();
        bufferedWriter.write(str);
        bufferedWriter.newLine();

        // Close the BufferedWriter object to flush the data to the file and release resources
        bufferedWriter.close();
    }
}
