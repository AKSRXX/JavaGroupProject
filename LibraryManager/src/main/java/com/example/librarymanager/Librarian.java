package com.example.librarymanager;

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
    public static void newBorrowsEvent(Member member, Item item) throws Exception
    {
        //System.out.print("Enter member ID: ");
        //String memberId = scanner.nextLine();

        //System.out.print("Enter item ID: ");
        //String itemId = scanner.nextLine();

        System.out.print("Enter borrow date (yyyy-mm-dd): ");
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

        //BorrowEvent eventMade = new BorrowEvent(member, item, borrowDate, dueDate);
        String savedInfo = member + " " + item + " " + borrowDate + " " + dueDate;
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


//        returnEvent returnMade = new returnsEvent(member, item, returnDate);
    };
}
