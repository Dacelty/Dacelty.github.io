import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        Employee[] arrEmp = service.getAllEmployees();
        System.out.println("Danh sách");
        service.show(arrEmp);


        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ID nhân viên cần tìm:");
        String fID = sc.nextLine();
        System.out.println("NV cần tìm là: ");
        service.findEmpByID(arrEmp, fID);
        System.out.println("Nhập tên NV cần tìm:");
        String fName = sc.nextLine();
        System.out.println("NV cần tìm là: ");
        service.findEmpByName(arrEmp, fName);
        System.out.println("Nhập giới tính NV cần tìm:");
        String g = sc.nextLine();
        Gender gender = Gender.valueOf(g);
        System.out.println("NV cần tìm là: ");
        service.findEmpByGender(arrEmp, gender);
        System.out.println("Các nhân viên cư trú tại Hà Nội là:");
        service.findEmpByAddress(arrEmp, "Ha Noi");
    }
}