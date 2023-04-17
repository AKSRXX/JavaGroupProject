import java.util.*;
public class Student extends Member {
    private Professor advisor;

    // constructor
    public Student(String name, String address, Date dob, String email, int ssn, int memberId, Professor advisor) {
        super(name, address, dob, email, ssn, memberId);
        this.advisor = advisor;
    }

    public Student(String name, String address, Date dob, String email, int ssn, int memberId) {
        super(name, address, dob, email, ssn, memberId);
    }

    // getters and setters
    public Professor getAdvisor() { return advisor; }
    public void setAdvisor(Professor advisor) { this.advisor = advisor; }
}
