import java.time.LocalDate;

public class MainEmployee {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "John", LocalDate.of(1990, 5,12),
                Gender.MALE, "0123456789", "john@gmail.com", "USA");
    }
}