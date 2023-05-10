import java.util.*;
import java.io.*;
public class Member extends Person {
    private int memberId;
    private List<Item> borrowedItems;

    // constructors
    public Member(String name, String address, Date dob, String email, SSN ssn, String memtype) {
        super(name, address, dob, email, ssn);
        //this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    // getters and setters
    public int getMemberId() { return memberId; }
    public void setMemberId(int memberId) { this.memberId = memberId; }

    // other methods
    public void borrowItem(Item item) {
        borrowedItems.add(item);
    }
    public void returnItem(Item item) { 
       for(Iterator<Item> iter = this.borrowedItems.iterator(); iter.hasNext(); ) {
            Item currentItem = iter.next();
            if (currentItem.getItemID() == item.getItemID()){
                iter.remove();
            }
       }
    }
    public void saveTo ( String textFile) throws Exception{
        FileWriter fileWriter = new FileWriter(textFile, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // Write the new collection to the file
        String str = getName() + " " + getAddress() + " " + getDob() + " " + getEmail() + " " + getSsn().getFormattedSSN() + " " + getMemberId();
        bufferedWriter.write(str);
        bufferedWriter.newLine();

        // Close the BufferedWriter object to flush the data to the file and release resources
        bufferedWriter.close();
    }
    public List<Item> getBorrowedItems() { return borrowedItems; }
}

