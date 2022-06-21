import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class Controller {
    StudentService service;
    ArrayList<Student> listStudent;
    Scanner sc;

    public Controller() {
        service = new StudentService();
        listStudent = service.getAllStudent();
        sc = new Scanner(System.in);
    }

    public void main(){
        while (true){
            Util.menu();
            System.out.println("Lựa chọn của bạn là: ");
            int choose = Integer.parseInt(sc.nextLine());

            switch (choose){
                case 1:
                    show();
                    break;
                case 2:
                    Student newStudent = createNewStudent();
                    service.addNewStudent(listStudent, newStudent);
                    break;
                case 3:
                    updateStudentPoint();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    showbyClassroom();
                    break;
                case 6:
                    sxHSTheoTen();
                    break;
                case 7:
                    sxHSTheoTuoi();
                    break;
                case 8:
                    sxHSTheoDiem();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
            }
        }
    }

    public void show(){
        for (Student s : listStudent){
            System.out.println(s);
        }
    }

    public Student createNewStudent(){
        System.out.println("Nhập id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập địa chỉ: ");
        String address = sc.nextLine();
        System.out.println("Nhập điểm: ");
        double point = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập lớp: ");
        String classroom = sc.nextLine();

        Student newStudent = new Student(id, name, age, address, point, classroom);
        return newStudent;
    }

    public Student findStudentById(){
        System.out.println("Nhập id học sinh: ");
        int id = Integer.parseInt(sc.nextLine());

        for(Student s : listStudent){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }

    public void showbyClassroom(){
        System.out.println("Nhập lớp: ");
        String lop = sc.nextLine();
        int count = 0;

        for (Student s : listStudent){
            if(s.getClassroom().equals(lop)){
                System.out.println(s);
                count++;
            }
        }

        if(count == 0){
            System.out.println("Không tìm thấy lớp");
        }
    }

    public void sxHSTheoTen(){
        listStudent.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Danh sách sau khi sắp xếp theo tên: ");
        show();
    }

    public void sxHSTheoTuoi(){
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println("Danh sách sau khi sắp xếp theo tuổi: ");
        show();
    }

    public void sxHSTheoDiem(){
        Collections.sort(listStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o1.getPoint(), o2.getPoint());
            }
        });
        System.out.println("Danh sách sau khi sắp xếp theo điểm: ");
        show();
    }

    public void updateStudentPoint(){
        Student fStudent = findStudentById();
        if(fStudent != null){
            System.out.println(fStudent);
        }else {
            System.out.println("Không tìm thấy học sinh");
        }
        System.out.println("Nhập điểm mới: ");
        double newPoint = Double.parseDouble(sc.nextLine());

        service.updateStudentPoint(fStudent, newPoint);
        System.out.println("Thông tin sau khi cập nhật: ");
        System.out.println(fStudent);
    }

    public void deleteStudent(){
        Student fStudent = findStudentById();
        if(fStudent != null){
            System.out.println(fStudent);
        }else {
            System.out.println("Không tìm thấy học sinh");
        }
        service.deleteStudent(listStudent, fStudent);
    }
}
