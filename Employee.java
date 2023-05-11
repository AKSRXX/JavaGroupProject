import java.util.*;
import java.io.*;
public class Employee extends Person 
{
    // constructor
    public Employee(String name, String address, Date dob, String email, SSN ssn) 
    {
        super(name, address, dob, email, ssn);
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
