//Dr. M. Arowollo
//4/12/2023
//Team
import java.util.*;
public class Person 
{
    private String name;
    private String address;
    private Date dob;
    private String email;
    private SSN ssn;
  
    // constructors
    public Person(String name, String address, Date dob, String email, SSN ssn) 
    {
      this.name = name;
      this.address = address;
      this.dob = dob;
      this.email = email;
      this.ssn = ssn;
    }
  
    // getters and setters
    //name
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    //address
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    //dob
    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
    //email
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    //ssn
    public SSN getSsn() { return ssn; }
    public void setSsn(SSN ssn) { this.ssn = ssn; }
    //people
    public Person getPerson() { return this; }
    
    // other methods
}

  
