import java.util.*;
import java.text.*;
public class EventHandler {

  public static Date getDob(Scanner scn){
    while(true){
      try{
        System.out.print("Enter Member Date of Birth (MM/DD/YYYY): ");
        String dobString = scn.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date dob = formatter.parse(dobString);
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


  public static Member NewMemberEvent(){
    Scanner scn = new Scanner(System.in);
    System.out.println("\nEnter Membership info: \n--------------------");
    System.out.print("Enter Member Name: ");
    String name = scn.nextLine();
    System.out.print("Enter Member Address: ");
    String address = scn.nextLine();
    Date dob = getDob(scn);
    System.out.print("Enter Member email: ");
    String email = scn.nextLine();
    SSN ssn = getSsn(scn);
    String memtype = getMemTypeString(scn);
    System.out.print("\nCreating a new member...");
    int memberId = (int) (Math.random() * (999999 - 100000)) + 100000;
    switch(memtype){
      case "Professor":
        Professor professor = new Professor(name, address, dob, email, ssn, memberId);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = dateFormat.format(dob);
        System.out.println("Member Successfully Created.");
        System.out.println("\nNew Member Information: \n-----------------------\nMember ID: " + professor.getMemberId() + "\nName: "+ professor.getName() + "\nMember Type: Professor\nAddress: " + professor.getAddress() + "\nDate of Birth: " + formattedDate + "\nEmail: " + professor.getEmail() + "\n-----------------------");
        scn.close();
        return professor;
      case "Student":
        Student student = new Student(name, address, dob, email, ssn, memberId);
        DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate2 = dateFormat2.format(dob);
        System.out.println("Member Successfully Created.");
        System.out.println("\nNew Member Information: \n-----------------------\nMember ID: " + student.getMemberId() + "\nName: "+ student.getName() + "\nMember Type: Student\nAddress: " + student.getAddress() + "\nDate of Birth: " + formattedDate2 + "\nEmail: " + student.getEmail() + "\n-----------------------");     
        scn.close();
        return student;
      //case "External":
        //External code
    }
    return null;
  }
}
