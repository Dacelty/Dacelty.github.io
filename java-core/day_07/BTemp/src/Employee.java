import java.time.LocalDate;

public class Employee {
    public String id;
    public String name;
    public LocalDate dob;
    public Gender gender;
    public String mobile;
    public String email;
    public String address;

    public Employee() {
    }

    public Employee(String id, String name, LocalDate dob, Gender gender, String mobile, String email, String address) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }
}