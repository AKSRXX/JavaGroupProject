import java.util.*;
public class Person 
{
    private String name;
    private String address;
    private Date dob;
    private String email;
    private int ssn;
  
    // constructors
    public Person(String name, String address, Date dob, String email, int ssn) 
    {
      this.name = name;
      this.address = address;
      this.dob = dob;
      this.email = email;
      this.ssn = ssn;
    }
  
    // getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getSsn() { return ssn; }
    public void setSsn(int ssn) { this.ssn = ssn; }
    
    // other methods
    //public String toString() { /* implementation */ }
}
/*  
class Employee extends Person 
{
    // constructor
    public Employee(String name, String address, Date dob, String email, int ssn) 
    {
        super(name, address, dob, email, ssn);
    }
}

class Librarian extends Employee 
{
    // constructor
    public Librarian(String name, String address, Date dob, String email, int ssn) {
        super(name, address, dob, email, ssn);
    }

    // other methods specific to Librarian
}

class Technician extends Employee {
    // constructor
    public Technician(String name, String address, Date dob, String email, int ssn) {
        super(name, address, dob, email, ssn);
    }

    // other methods specific to Technician
}

class Member extends Person {
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
    //public void borrowItem(Item item) {  implementation  }
    //public void returnItem(Item item) {  implementation  }
    public List<Object> getBorrowedItems() { return borrowedItems; }
}

class Student extends Member {
    private Professor advisor;

    // constructor
    public Student(String name, String address, Date dob, String email, int ssn, int memberId, Professor advisor) {
        super(name, address, dob, email, ssn, memberId);
        this.advisor = advisor;
    }

    // getters and setters
    public Professor getAdvisor() { return advisor; }
    public void setAdvisor(Professor advisor) { this.advisor = advisor; }
    }

class Professor extends Member {
    private List<Student> supervisedStudents;

    // constructor
    public Professor(String name, String address, Date dob, String email, int ssn, int memberId) {
        super(name, address, dob, email, ssn, memberId);
        this.supervisedStudents = new ArrayList<>();
    }
    public List<Student> getSupervisedStudents() { return supervisedStudents; }
}
*/
  
