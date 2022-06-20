import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Movie m1 = new Movie();
        m1.myMethod();

        m1.setId(1);
        m1.setName("ABC");
        m1.setGenre("Comedy");
        m1.setDirector("113");
        m1.setDob(LocalDate.of(1990, 12, 3));

        System.out.println(m1);
    }
}
