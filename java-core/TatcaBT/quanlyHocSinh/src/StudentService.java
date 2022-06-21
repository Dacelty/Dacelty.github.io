import java.util.ArrayList;

public class StudentService implements IStudentService{

    public ArrayList<Student> getAllStudent(){
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student(1, "Hoa" , 16, "HN", 8.5, "Lớp 10"));
        list.add(new Student(2, "Quang" , 17, "HN", 9, "Lớp 11"));
        list.add(new Student(3, "Huy" , 18, "HN", 7, "Lớp 12"));
        list.add(new Student(4, "Tuấn" , 16, "HN", 8, "Lớp 10"));
        list.add(new Student(5, "Hòa" , 20, "HN", 6, "Lớp 11"));
        list.add(new Student(6, "Chi" , 15, "HN", 10, "Lớp 12"));

        return list;
    }



    @Override
    public void addNewStudent(ArrayList<Student> list,Student student) {
        list.add(student);
    }

    @Override
    public void updateStudentPoint(Student student, double newPoint) {
        student.setPoint(newPoint);
    }

    @Override
    public void deleteStudent(ArrayList<Student> list, Student student) {
        list.remove(student);
    }
}
