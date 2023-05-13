package com.it3330.librarymanager;

import java.nio.file.Path;
import java.util.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


class EventHandlerMain{

    static String[] sections = {"ARTS", "SCIENCES", "NEWSPAPERS", "LAW"};
    static String[] collections = {};

    //You can either implement your events in these functions, or you can write an Event class and call a static function here.

    public static void newMemberEvent(String name, String address, Date dob, String email, String stringSSN, String memtype) throws Exception{
        SSN ssn = new SSN(stringSSN);
        switch (memtype) {
            case "Professor" -> {
                Professor professor = new Professor(name, address, dob, email, ssn);
                DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                String formattedDate = dateFormat.format(dob);
                System.out.println("Professor Successfully Created.");
                System.out.println("\nNew Professor Information: \n-----------------------\nMember ID: " + professor.getMemberId() + "\nName: " + professor.getName() + "\nMember Type: Professor\nAddress: " + professor.getAddress() + "\nDate of Birth: " + formattedDate + "\nEmail: " + professor.getEmail() + "\n-----------------------");
                professor.saveTo("membershipdatabasefile.txt");
            }
            case "Student" -> {
                Student student = new Student(name, address, dob, email, ssn);
                DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
                String formattedDate2 = dateFormat2.format(dob);
                System.out.println("Student Successfully Created.");
                System.out.println("\nNew Student Information: \n-----------------------\nMember ID: " + student.getMemberId() + "\nName: " + student.getName() + "\nMember Type: Student\nAddress: " + student.getAddress() + "\nDate of Birth: " + formattedDate2 + "\nEmail: " + student.getEmail() + "\n-----------------------");
                student.saveTo("membershipdatabasefile.txt");
            }
            case "External" -> {
                External external = new External(name, address, dob, email, ssn);
                DateFormat dateFormat3 = new SimpleDateFormat("MM/dd/yyyy");
                String formattedDate3 = dateFormat3.format(dob);
                System.out.println("External Successfully Created.");
                System.out.println("\nNew External Information: \n-----------------------\nMember ID: " + external.getMemberId() + "\nName: " + external.getName() + "\nMember Type: External\nAddress: " + external.getAddress() + "\nDate of Birth: " + formattedDate3 + "\nEmail: " + external.getEmail() + "\n-----------------------");
                external.saveTo("membershipdatabasefile.txt");
            }
        }


    };
    public static void newCollectionEvent(String newCollection) throws Exception {
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
        }
    }

    public static void writeListToFile(ArrayList<String> list, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (String line : list) {
            writer.write(line + "\n");
        }
        writer.close();
    }

    public static ArrayList<String> newCheckOverdues(String memberId, String dateInput) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = null;
        currentDate = format.parse(dateInput);

        ArrayList<String> check = EventHandlerMain.readFileToList("borrows.txt");
        ArrayList<String> updatedCheck = new ArrayList<>();

        for (String item : check) {
            String[] words = item.split(", ");
            String member = words[0];
            String dueDate = words[3];

            Date dueDate2 = format.parse(dueDate);

            if (!member.equals(memberId) || currentDate.before(dueDate2)){
                continue;
            }
            updatedCheck.add(item);
        }
        return updatedCheck;
    };



    public static void newBorrowsEvent(String memberId, String itemId, String borrowDateString, String dueDateString) throws Exception
    {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date borrowDate = null;
        try {
            borrowDate = format.parse(borrowDateString);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.print("Invalid Date");
        }

        Date dueDate = null;
        try {
            dueDate = format.parse(dueDateString);
        } catch (ParseException e) {
            //e.printStackTrace();
            System.out.print("Invalid Date");
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


    public static void newRemoveMemberEvent(String memberID) {
        List<String> lines = new ArrayList<>();
        String line;
        Boolean added = false;
        try (BufferedReader reader = new BufferedReader(new FileReader("membershipdatabasefile.txt"))) {
            while ((line = reader.readLine()) != null) {
                if (!line.contains(memberID)) {
                    lines.add(line);
                    added = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (added){
            System.out.print("No Member Found To Edit");
        }

        try (FileWriter writer = new FileWriter("membershipdatabasefile.txt", false)) {
            for (String l : lines) {
                writer.write(l + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void newReturnEvent(String file, String targetID) {
        List<String> lines = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((line = reader.readLine()) != null) {
                if (!line.contains(targetID)) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(file, false)) {
            for (String l : lines) {
                writer.write(l + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<String> readFileToList(String fileName) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            list.add(line);
        }
        reader.close();
        return list;
    }

    public static void removesCollectionEvent(String collectionToRemove) {
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
    public static void newEmployeeEvent(String name, String address, String dobString, String email, SSN ssn, String title) throws Exception{
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date dob = formatter.parse(dobString);
        Employee emp = new Employee(name, address, dob, email, ssn, title);
        System.out.println("\nCreating new employee...");
        emp.saveTo("employeedatabasefile.txt");
        System.out.println("\nEmployee added to database.\n");
    };
    

    //You are free to implememnt other events that you see needs to be implemented
    // DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    // String formattedDate = dateFormat.format(dob);
    public static void main(String [] args)throws Exception{
        // ProjectMain.mainMenu();
        // System.out.print("Enter your option number: ");
        // int option = scanner.nextInt();
        // // while(true){
        //     switch (option) {
        //         case 1:
        //         try {
        //             ProjectMain.newMemberEvent();
        //             break;
        //         } catch (Exception e) {
        //             // TODO: handle exception
        //         }
        //         case 2:
        //             try {
        //                 ProjectMain.newCollectionEvent();
        //                 break;
        //             } catch (Exception e) {
        //                 // TODO: handle exception
        //             }
        //         case 3:
        //             ProjectMain.newRemoveMemberEvent();
        //             break;
        //         case 4:
        //         try {
        //             ProjectMain.removesCollectionEvent();
        //             break;
        //         } catch (Exception e) {
        //             // TODO: handle exception
        //         }
        //         case 5:
        //             ProjectMain.newEmployeeEvent();
        //             break;
        //         case 6:
        //         try{
        //             ProjectMain.newBorrowsEvent();
        //             break;
        //         } catch (Exception e) {
        //             // TODO: handle exception
        //         }
        //         case 7:
        //             ProjectMain.newReturnEvent();
        //             break;
        //         case 8:
        //             ProjectMain.newCheckOverdues();
        //             break;
        //         case 9:
        //             System.exit(0);
        //             break;
        //         default:
        //             System.out.println("Invalid operator.");
        //     //         continue;
        //     // }
        // }
    }
}