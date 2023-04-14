import java.util.Date;

public class TestingGround {
  public static void main(String[] args) {
    Professor professor = new Professor("Professor Name","Address",new Date(),"briden.kirk@yahoo.com",12345,544321);
    Student student = new Student("Student Name", "Address", new Date(), "email", 10293, 12039,professor);
    professor.aquireStudent(student);
    for (Student student1 : professor.getSupervisedStudents()){
      System.out.println(student1.getName());
    }
  }
}
