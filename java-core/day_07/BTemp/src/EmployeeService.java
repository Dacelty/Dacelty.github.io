import java.time.LocalDate;

public class EmployeeService {
    public Employee[] getAllEmployees() {
        Employee[] arrEmp = new Employee[5];
        arrEmp[0] = new Employee("NV01", "NTP", LocalDate.of(1990, 5,12),
                Gender.MALE, "0123456789", "NTP@gmail.com", "Ho Chi Minh");
        arrEmp[1] = new Employee("NV02", "NTA", LocalDate.of(1994, 5,12),
                Gender.FEMALE, "0123456789", "NTA@gmail.com", "Ha Noi");
        arrEmp[2] = new Employee("NV03", "NTB", LocalDate.of(1995, 5,12),
                Gender.FEMALE, "0123456789", "NTB@gmail.com", "Quang Binh");
        arrEmp[3] = new Employee("NV04", "NTC", LocalDate.of(1996, 5,12),
                Gender.MALE, "0123456789", "NTC@gmail.com", "Ha Noi");
        arrEmp[4] = new Employee("NV05", "NTD", LocalDate.of(2000, 5,12),
                Gender.MALE, "0123456789", "NTD@gmail.com", "Hai Phong");


        return arrEmp;
    }

    public void show(Employee[] arr){
        for (Employee b : arr){
            System.out.println(b.id + " - " + b.name + " - " + b.dob + " - " + b.gender + " - " + b.mobile + " - " + b.email + " - " + b.address);
        }
    }

    public void findEmpByID(Employee[] arr, String fID){
        int count = 0;
        for (Employee b : arr){
            if (b.id.contains(fID)){
                count++;
                System.out.println(b.id + " - " + b.name + " - " + b.dob + " - " + b.gender + " - " + b.mobile + " - " + b.email + " - " + b.address);
            }
        }
        if (count == 0){
            System.out.println("Không tìm thấy nhân viên có ID này.");
        }
    }

    public void findEmpByName(Employee[] arr, String fName){
        int count = 0;
        for (Employee b : arr){
            if (b.name.contains(fName)){
                count++;
                System.out.println(b.id + " - " + b.name + " - " + b.dob + " - " + b.gender + " - " + b.mobile + " - " + b.email + " - " + b.address);
            }
        }
        if (count == 0){
            System.out.println("Không tìm thấy nhân viên có tên này.");
        }
    }

    public void findEmpByGender(Employee[] arr, Gender gender){
        int count = 0;
        for (Employee b : arr){
            if (b.gender == gender){
                count++;
                System.out.println(b.id + " - " + b.name + " - " + b.dob + " - " + b.gender + " - " + b.mobile + " - " + b.email + " - " + b.address);
            }
        }
        if (count == 0){
            System.out.println("Không tìm thấy nhân viên có giới tính này.");
        }
    }

    public void findEmpByAddress(Employee[] arr, String fAdd){
        int count = 0;
        for (Employee b : arr){
            if (b.address.contains(fAdd)){
                count++;
                System.out.println(b.id + " - " + b.name + " - " + b.dob + " - " + b.gender + " - " + b.mobile + " - " + b.email + " - " + b.address);
            }
        }
        if (count == 0){
            System.out.println("Không tìm thấy nhân viên nào ở địa chỉ này.");
        }
    }
}
