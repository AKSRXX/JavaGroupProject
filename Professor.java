import java.util.*;
public class Professor extends Member {
    private List<Student> supervisedStudents;

    // constructor
    public Professor(String name, String address, Date dob, String email, int ssn, int memberId) {
        super(name, address, dob, email, ssn, memberId);
        this.supervisedStudents = new ArrayList<>();
    }

    //Functions specific to Professor
    public List<Student> getSupervisedStudents() { return supervisedStudents; }
    public void aquireStudent(Student student){ supervisedStudents.add(student); }
    public void removeStudent(Student student){
        for(Iterator<Student> iter = this.supervisedStudents.iterator(); iter.hasNext(); ) {
            Student currentStudent = iter.next();
            if (currentStudent.getMemberId() == student.getMemberId()){
                iter.remove();
            }
       }
    }


}
