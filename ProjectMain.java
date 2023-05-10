import java.util.*;
import java.text.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.*;

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
    public static void newCollectionEvent() throws Exception {
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
            // Open the file for writing
            FileWriter fileWriter = new FileWriter("collections.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the new collection to the file
            bufferedWriter.write(newCollection.toUpperCase());
            bufferedWriter.newLine();

            // Close the BufferedWriter object to flush the data to the file and release resources
            bufferedWriter.close();
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
    public static void removesCollectionEvent() {
        System.out.println("Enter the collection to remove:");
        String collectionToRemove = scanner.next().toUpperCase();
    
        try {
            // Read the contents of the file into a StringBuilder object
            File file = new File("collections.txt");
            Scanner fileScanner = new Scanner(file);
            StringBuilder fileContents = new StringBuilder();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().toUpperCase();
                if (!line.equals(collectionToRemove)) {
                    fileContents.append(line).append(System.lineSeparator());
                }
            }
            fileScanner.close();
    
            // Write the updated contents back to the file
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(fileContents.toString());
            fileWriter.close();
    
            // Remove the collection from the collections array
            String[] newCollections = new String[collections.length - 1];
            int j = 0;
            for (int i = 0; i < collections.length; i++) {
                if (!collections[i].equalsIgnoreCase(collectionToRemove)) {
                    newCollections[j] = collections[i];
                    j++;
                }
            }
            collections = newCollections;
    
            System.out.println("Collection removed from file and array.");
            for (String collection : collections) {
                System.out.print(collection + " ");
            }
        } catch (IOException e) {
            System.out.println("Error removing collection: " + e.getMessage());
        }
    }
    public static void newRemoveCollectionEvent()
    {
        System.out.println("Enter the name of the collection to remove:");
        String collectionToRemove = scanner.next();

        boolean found = false;
        int indexToRemove = -1;
        for (int i = 0; i < collections.length; i++) {
            if (collections[i].equalsIgnoreCase(collectionToRemove)) {
                found = true;
                indexToRemove = i;
                break;
            }
        }

        if (found) {
            String[] newCollections = new String[collections.length - 1];
            System.arraycopy(collections, 0, newCollections, 0, indexToRemove);
            System.arraycopy(collections, indexToRemove + 1, newCollections, indexToRemove, collections.length - indexToRemove - 1);
            collections = newCollections;
            System.out.println("Collection removed.");
            for (String collection : collections) {
                System.out.print(collection + " ");
            }
        } else {
            System.out.println("Collection not found.");
        }
    };
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
    public static void newBorrowsEvent()
    {
        Librarian.newBorrowsEvent(null, null);
        //System.out.print("Enter member ID: ");
        //String memberId = scanner.nextLine();

        //System.out.print("Enter item ID: ");
        //String itemId = scanner.nextLine();

        /*System.out.print("Enter borrow date (yyyy-mm-dd): ");
        String borrowDateString = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date borrowDate = null;
        try {
            borrowDate = format.parse(borrowDateString);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.print("Invalid Date");
            newBorrowsEvent(member, item);
        }
        //Date borrowDate = parseDate(borrowDateString);

        System.out.print("Enter due date (yyyy-mm-dd): ");
        String dueDateString = scanner.nextLine();
        Date dueDate = null;
        try {
            dueDate = format.parse(dueDateString);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.print("Invalid Date");
            newBorrowsEvent(member, item);
        }

        BorrowEvent eventMade = new BorrowEvent(member, item, borrowDate, dueDate);*/
    };
    public static void newReturnEvent()
    {
        Librarian.newReturnsEvent(null, null);
        //System.out.print("Enter member ID: ");
        //String memberId = scanner.nextLine();

        //System.out.print("Enter item ID: ");
        //String itemId = scanner.nextLine();

        /*System.out.print("Enter return date (yyyy-mm-dd): ");
        String returnDateString = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date returnDate = null;
        try {
            returnDate = format.parse(returnDateString);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.print("Invalid Date");
            newReturnsEvent(member, item);
        }


        returnsEvent returnMade = new returnsEvent(member, item, returnDate);*/
    };
    
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
                    try {
                        ProjectMain.newCollectionEvent();
                        break;
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                case 3:
                    ProjectMain.newRemoveMemberEvent();
                    break;
                case 4:
                try {
                    ProjectMain.removesCollectionEvent();
                    break;
                } catch (Exception e) {
                    // TODO: handle exception
                }
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
