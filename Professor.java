import java.util.*;
public class Professor extends Member {
    private List<Student> supervisedStudents;

    // constructor
    public Professor(String name, String address, Date dob, String email, int ssn, int memberId) {
        super(name, address, dob, email, ssn, memberId);
        this.supervisedStudents = new ArrayList<>();
    }
    public List<Student> getSupervisedStudents() { return supervisedStudents; }
}
