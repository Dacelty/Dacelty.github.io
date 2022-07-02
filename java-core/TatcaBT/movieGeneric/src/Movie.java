import java.time.LocalDate;

public class Movie extends Film {
    private double length;

    public Movie() {
    }

    public Movie(int id, String name, String genre, String director, LocalDate dob, double length) {
        super(id, name, genre, director, dob);
        this.length = length;
    }

    public Movie(String s, String abc, String comedy, String s1, LocalDate of) {
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + length;
    }



}
