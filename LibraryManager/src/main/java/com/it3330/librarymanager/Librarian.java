package com.it3330.librarymanager;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.*;
public class Librarian extends Employee 
{
    static Scanner scanner = new Scanner(System.in);
    // constructor
    public Librarian(String name, String address, Date dob, String email, SSN ssn) {
        super(name, address, dob, email, ssn);
    }

    // other methods specific to Librarian

    public static void newCheckOverdues() throws Exception{
        System.out.print("Enter the Members Id to check overdues: ");
        String mStr = scanner.next();
        String dobInput = "2023-05-11";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = null;
        currentDate = format.parse(dobInput);
        
        ArrayList<String> check = ProjectMain.readFileToList("borrows.txt");
        ArrayList<String> updatedCheck = new ArrayList<>();
    
        for (String item : check) {
            String[] words = item.split(", ");
            String member = words[0];
            //String itemChecked = words[1];
            //String borrowDate = words[3];
            String dueDate = words[3];

            Date dueDate2 = format.parse(dueDate);


    
            if (member.equals(mStr) == false || currentDate.before(dueDate2) == true){
                continue;
            }
    
            updatedCheck.add(item);

        }
        for (String item : updatedCheck){
            System.out.println(item);

        }
        //writeListToFile(updatedCheck, "membershipdatabasefile.txt");
    
};



    public static void newBorrowsEvent() throws Exception
    {
        System.out.print("Enter member ID: ");
        String memberId = scanner.nextLine();

        System.out.print("Enter item ID: ");
        String itemId = scanner.nextLine();

        System.out.print("Enter borrow date (yyyy-mm-dd): ");
        String borrowDateString = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date borrowDate = null;
        try {
            borrowDate = format.parse(borrowDateString);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.print("Invalid Date");
            newBorrowsEvent();
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
            newBorrowsEvent();
        }
        
        //BorrowEvent eventMade = new BorrowEvent(member, item, borrowDate, dueDate);
        String savedInfo = memberId + ", " + itemId + ", " + borrowDateString + ", " + dueDateString;
        FileWriter fileWriter = new FileWriter("borrows.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // Write the new collection to the file
        bufferedWriter.write(savedInfo);
        bufferedWriter.newLine();

        // Close the BufferedWriter object to flush the data to the file and release resources
        bufferedWriter.close();
    };
    public static void newReturnsEvent(Member member, Item item)
    {
        //System.out.print("Enter member ID: ");
        //String memberId = scanner.nextLine();

        //System.out.print("Enter item ID: ");
        //String itemId = scanner.nextLine();

        System.out.print("Enter return date (yyyy-mm-dd): ");
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


        //returnsEvent returnMade = new returnsEvent(member, item, returnDate);
    };

    public static void newBorrowsEvent(Object o, Object o1) {

    }
}
