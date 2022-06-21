import java.util.ArrayList;

public interface IStudentService {
    public void addNewStudent(ArrayList<Student> list,Student student);

    public void updateStudentPoint(Student student, double newPoint);

    public void deleteStudent(ArrayList<Student> list, Student student);
}
