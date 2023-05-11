package com.example.librarymanager;

import java.util.ArrayList;
import java.util.Scanner;

public class SSN {
    static Scanner scanner = new Scanner(System.in);
    private String areaNumber;
    private String groupNumber;
    private String serialNumber;
    private String fullSSN;
    private static ArrayList<String> usedSSNs = new ArrayList<>();
    //input using area group and serial number
    public SSN(String areaNumber, String groupNumber, String serialNumber) {
        String full = areaNumber + groupNumber + serialNumber;
        this.fullSSN = checker2(full);
        this.areaNumber = this.fullSSN.substring(0, 3);
        this.groupNumber = this.fullSSN.substring(3, 5);
        this.serialNumber = this.fullSSN.substring(5);
    }
    //input with dashes
    public SSN(String ssnWithDashes) {
        String[] parts = ssnWithDashes.split("-");
        if (parts.length == 1)
        {
            String full = parts[0];
            this.fullSSN = checker2(full);
            this.areaNumber = this.fullSSN.substring(0, 3);
            this.groupNumber = this.fullSSN.substring(3, 5);
            this.serialNumber = this.fullSSN.substring(5);
        }
        if (parts.length == 3)
        {
            String full = parts[0] + parts[1] + parts[2];
            this.fullSSN = checker2(full);
            this.areaNumber = this.fullSSN.substring(0, 3);
            this.groupNumber = this.fullSSN.substring(3, 5);
            this.serialNumber = this.fullSSN.substring(5);
        }
    }

    //methods
    public String checker2(String input) {
        String a = input.substring(0, 3);
        String b = input.substring(3, 5);
        String c = input.substring(5);
        String d = a + "-" + b + "-" + c;
        if(input.length() != 9 ||  usedSSNs.contains(d) == true)
        {
            System.out.println("Invalid Input: Enter New SSN");
            String input2 = scanner.nextLine();
            return input2;

        }
        else {
            return input;
        }
    }
    //checks if in use
    public boolean isUsed() {
        return usedSSNs.contains(getFormattedSSN());
    }
    //adds to ArrayList
    public void addToUsedSSNs() {
        usedSSNs.add(getFormattedSSN());
    }
    //returns formatted ssn
    public String getFormattedSSN() {
        return areaNumber + "-" + groupNumber + "-" + serialNumber;
    }

    // getters and setters
    public String getAreaNumber() {
        return areaNumber;
    }

    public void setAreaNumber(String areaNumber) {
        this.areaNumber = areaNumber;
    }
    //group number
    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }
    //serial number
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    //already used ssns
    public static ArrayList<String> getUsedSSNs() {
        return usedSSNs;
    }

    public static void setUsedSSNs(ArrayList<String> usedSSNs) {
        SSN.usedSSNs = usedSSNs;
    }
}

  
