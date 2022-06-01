import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate toDay = LocalDate.now();
        System.out.println("Hôm nay là: "+toDay);

        LocalDate date = LocalDate.of(2020,12,10);
        System.out.println(date);
    }
}
