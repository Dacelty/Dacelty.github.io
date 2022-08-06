import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> listStudent;
        studentService s = new studentService();
        Scanner scanner = new Scanner(System.in);

        listStudent = s.getAllStudents();

        System.out.println("Danh sách đầu tiên:");
        for (Object stu : listStudent) {
            System.out.println(stu);
        }
        System.out.println();

        while (true) {
            System.out.println();
            System.out.println("Có thể thực hiện các công việc sau:");
            System.out.println("#1. Sắp xếp học sinh theo fullName, nếu giống fullName thì ai nhiều tuổi hơn thì đứng trước.");
            System.out.println("#2. Sắp xếp học sinh theo tuổi tăng dần, nếu bằng tuổi thì xếp theo GPA giảm dần.");
            System.out.println("#3. Sắp xếp theo tên. (Ví dụ là Hoàng Văn A, thì chỉ xét A thôi).");
            System.out.println("#4. Thoát CT.");
            System.out.println();
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1 -> {
                    listStudent.sort((o1, o2) -> {
                        if (!o1.getFullName().equals(o2.getFullName())) {
                            return o1.getFullName().compareTo(o2.getFullName());
                        } else {
                            return o2.getAge() - o1.getAge();
                        }
                    });
                    System.out.println("Danh sách sau khi sắp xếp: ");
                    for (Object stu : listStudent) {
                        System.out.println(stu);
                    }
                    System.out.println();
                }
                case 2 -> {
                    listStudent.sort((o1, o2) -> {
                        if (!(o1.getAge() == o2.getAge())) {
                            return o1.getAge() - o2.getAge();
                        } else {
                            return o2.getGpa() - o1.getGpa();
                        }
                    });
                    System.out.println("Danh sách sau khi sắp xếp: ");
                    for (Object stu : listStudent) {
                        System.out.println(stu);
                    }
                    System.out.println();
                }
                case 3 -> {
                    listStudent.sort(Comparator.comparing(Student::getFirstName));
                    System.out.println("Danh sách sau khi sắp xếp: ");
                    for (Object stu : listStudent) {
                        System.out.println(stu);
                    }
                    System.out.println();
                }
                case 4 -> System.exit(0);
            }
        }

    }
}
