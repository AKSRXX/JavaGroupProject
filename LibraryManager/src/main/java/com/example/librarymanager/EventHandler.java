package com.example.librarymanager;

import java.util.*;
import java.text.*;
//hi
public class EventHandler {

  public static Date getDob(Scanner scn){
    while(true){
      try{
        System.out.print("Enter Member Date of Birth (MM/DD/YYYY): ");
        String dobString = scn.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date dob = formatter.parse(dobString);
        System.out.print(dob);
        return dob;
      }catch(Exception e){
        System.out.println("Invalid date format.");
      }
    }
  }

  public static String getMemTypeString(Scanner scn){
    while(true){
      System.out.print("Enter Member Type (Professor/Student/External): ");
      String memTypeString = scn.nextLine();
      if(memTypeString.equals("Professor") || memTypeString.equals("Student") || memTypeString.equals("External")){
        return memTypeString;
      }else{
        System.out.println("Please enter one of the acceptable options.");
        continue;
      }
    }
  }

  public static SSN getSsn(Scanner scn){
    while(true){
      System.out.print("Enter Member SSN: ");
      try{
        String ssn = scn.nextLine();
        if(ssn.length() != 9 && !ssn.contains("-")){
          throw new Exception();
        }
        if(ssn.contains("-") && ssn.length() != 11){
          throw new Exception();
        }
        SSN newSSN = new SSN(ssn);
        return newSSN;
      }catch(Exception e){
        System.out.println("Please enter an valid SSN.");
      }
    }
  }
}
