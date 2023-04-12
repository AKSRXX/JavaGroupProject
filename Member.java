import java.util.*;
public class Member extends Person {
    private int memberId;
    private List<Object> borrowedItems;

    // constructors
    public Member(String name, String address, Date dob, String email, int ssn, int memberId) {
        super(name, address, dob, email, ssn);
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    // getters and setters
    public int getMemberId() { return memberId; }
    public void setMemberId(int memberId) { this.memberId = memberId; }

    // other methods
    //public void borrowItem(Item item) { /* implementation */ }
    //public void returnItem(Item item) { /* implementation */ }
    public List<Object> getBorrowedItems() { return borrowedItems; }
}
