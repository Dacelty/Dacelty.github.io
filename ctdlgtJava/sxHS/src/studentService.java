import java.util.ArrayList;

public class studentService {
    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> listStudent = new ArrayList<Student>();
        listStudent.add(new Student("Drew Barrett Anderson",20,9));
        listStudent.add(new Student("Drew Barrett Anderson",14,9));
        listStudent.add(new Student("Mohammad Yang Kadir Haitham",18,8));
        listStudent.add(new Student("Bluebell Kavanaugh Johns Thompson",19,7));
        listStudent.add(new Student("Lauryn Bentley Stacey Grace",19,9));
        listStudent.add(new Student("Aston Hills Ballad",17,7));
        listStudent.add(new Student("Hubert Thorne Franklin",15,6));
        listStudent.add(new Student("Cherish Rivas Cruz",16,5));

        return listStudent;

    }
}
