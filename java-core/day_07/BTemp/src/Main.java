import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        Employee[] arrEmp = service.getAllEmployees();
        System.out.println("Danh sách");
        service.show(arrEmp);

    }
}
