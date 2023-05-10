import java.util.*;
import java.text.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class ProjectMain{
    static Scanner scanner = new Scanner(System.in);
    static String[] sections = {"ARTS", "SCIENCES", "NEWSPAPERS", "LAW"};
    static String[] collections = {"BOOKS", "NEWSPAPERS", "DVDS", "JOURNALS"};

    public static void mainMenu(){
        System.out.println("University of Java Library System");
        System.out.println("Menu Options");
        System.out.println("1. New Membership");
        System.out.println("2. New Collection");
        System.out.println("3. Remove Membership");
        System.out.println("4. Remove Item from Collection");
        System.out.println("5. New Employee");
        System.out.println("6. Borrow Item");
        System.out.println("7. Return Item");
        System.out.println("8. Check overdues");
        System.out.println("9. Quit");
        System.out.println("");
    }


    //You can either implement your events in these functions, or you can write an Event class and call a static function here.
    public static Member newMemberEvent(){
        Scanner scn = new Scanner(System.in);
        System.out.println("\nEnter Membership info: \n--------------------");
        System.out.print("Enter Member Name: ");
        String name = scn.nextLine();
        System.out.print("Enter Member Address: ");
        String address = scn.nextLine();
        Date dob = EventHandler.getDob(scn);
        System.out.print("Enter Member email: ");
        String email = scn.nextLine();
        SSN ssn = EventHandler.getSsn(scn);
        String memtype = EventHandler.getMemTypeString(scn);
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
            //Save the new member into the membership database
            //mem.saveTo("membershipdatabasefile.txt");
            return professor;
          case "Student":
            Student student = new Student(name, address, dob, email, ssn, memberId);
            DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
            String formattedDate2 = dateFormat2.format(dob);
            System.out.println("Member Successfully Created.");
            System.out.println("\nNew Member Information: \n-----------------------\nMember ID: " + student.getMemberId() + "\nName: "+ student.getName() + "\nMember Type: Student\nAddress: " + student.getAddress() + "\nDate of Birth: " + formattedDate2 + "\nEmail: " + student.getEmail() + "\n-----------------------");     
            scn.close();
            //Save the new member into the membership database
            //mem.saveTo("membershipdatabasefile.txt");
        System.out.println("New Member Successfully Saved to file."); 
            return student;
            
          //case "External":
            //External code
        }
        return null;


    };
    public static void newCollectionEvent() {
        System.out.println("Enter a new collection to add:");
        String newCollection = scanner.next();
        boolean alreadyExists = false;
        for (String collection : collections) {
            if (collection.equalsIgnoreCase(newCollection)) {
                alreadyExists = true;
                break;
            }
        }

        if (alreadyExists) 
        {
            System.out.println("Collection already exists in array.");
        } else 
        {
            String[] newCollections = new String[collections.length + 1];
            System.arraycopy(collections, 0, newCollections, 0, collections.length);
            newCollections[collections.length] = newCollection.toUpperCase();
            collections = newCollections;
            System.out.println("Collection added to array.");
            for (String collection : collections) {
                System.out.print(collection + " ");
            }
            System.exit(0);
        }
    }
    public static void newRemoveMemberEvent()
    {

    };
    public static void newRemoveCollectionEvent(){};
    public static void newEmployeeEvent()
    {
        System.out.println("Enter Employee info: ");
        System.out.print("Enter Employee Name: ");
        String name = scanner.next();
        System.out.print("Enter Employee Address: ");
        String address = scanner.next();
        System.out.print("Enter Employee Date of Birth (yyyy-MM-dd): ");
        String dobInput = scanner.next();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dob = null;
        try {
            dob = format.parse(dobInput);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.print("Invalid Date");
            newEmployeeEvent();
        }
        System.out.print("Enter Employee email: ");
        String email = scanner.next();
        System.out.print("Enter Employee SSN: ");
        String memSsn = scanner.next();
        SSN ssn = new SSN(memSsn);
        System.out.print("Creating a new member...");
        Employee emp = new Employee(name,address,dob,email,ssn);
        //System.out.print("The membership ID is: "+mem.getID());
        //Save the new member into the membership database
        //mem.saveTo("membershipdatabasefile.txt");
        System.out.println("New Member Successfully Saved to file."); 
    };
    public static void newBorrowsEvent(){};
    public static void newReturnEvent(){};
    public static void newCheckOverdues(){};
    //You are free to implememnt other events that you see needs to be implemented

    public static void main(String [] args){
        ProjectMain.mainMenu();

        System.out.print("Enter your option number: ");
        int option = scanner.nextInt();
        while(true){
            switch (option) {
                case 1:
                    ProjectMain.newMemberEvent();
                    break;
                case 2:
                    ProjectMain.newCollectionEvent();
                    break;
                case 3:
                    ProjectMain.newRemoveMemberEvent();
                    break;
                case 4:
                    ProjectMain.newRemoveCollectionEvent();
                    break;
                case 5:
                    ProjectMain.newEmployeeEvent();
                    break;
                case 6:
                    ProjectMain.newBorrowsEvent();
                    break;
                case 7:
                    ProjectMain.newReturnEvent();
                    break;
                case 8:
                    ProjectMain.newCheckOverdues();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid operator.");
                    continue;
            }
        }
        




    }
    
}
