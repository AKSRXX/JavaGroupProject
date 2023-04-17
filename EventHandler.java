import java.util.*;
import java.text.*;
public class EventHandler {

  public static Date getDOB(Scanner scn){
    while(true){
      try{
        System.out.print("Enter Member Date of Birth (DD/MM/YYYY): ");
        String dobString = scn.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dob = formatter.parse(dobString);
        return dob;
      }catch(Exception e){
        System.out.println("Invalid date format.");
      }
    }
  }

  public static String getMemTypeString(Scanner scn){
    while(true){
      System.out.print("Enter Member Type (Professor/Member/External): ");
      String memTypeString = scn.nextLine();
      if(memTypeString.equals("Professor") || memTypeString.equals("Member") || memTypeString.equals("External")){
        return memTypeString;
      }else{
        System.out.println("Please enter one of the acceptable options.");
        continue;
      }
    }
  }


  public static void NewMemberEvent(){
    Scanner scn = new Scanner(System.in);
    System.out.println("Enter Membership info: \n--------------------");
    System.out.print("Enter Member Name: ");
    String name = scn.nextLine();
    System.out.print("Enter Member Address: ");
    String address = scn.nextLine();
    Date dob = getDOB(scn);
    System.out.print("Enter Member email: ");
    String email = scn.nextLine();
    System.out.print("Enter Member SSN: ");
    int ssn = Integer.parseInt(scn.nextLine());
    String memtype = getMemTypeString(scn);
    System.out.print("Creating a new member...");
    int memberId = (int) (Math.random() * (99999 - 10000)) + 10000;
    switch(memtype){
      case "Professor":
        Professor professor = new Professor(name, address, dob, email, ssn, memberId);
        System.out.println("The membership ID is: "+professor.getMemberId());

        break;
      case "Student":
        Student student = new Student(name, address, dob, email, ssn, memberId);
        System.out.println("The membership ID is: "+student.getMemberId());
        break;
      //case "External":
        //External code
    }
    scn.close();
  }
}
