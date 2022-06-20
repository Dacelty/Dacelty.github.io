import java.time.LocalDate;

public class Serial extends Film {
    private int episodesCount;
    private double averagelength;

    public Serial() {
    }

    public Serial(int id, String name, String genre, String director, LocalDate dob, int episodesCount, double averagelength) {
        super(id, name, genre, director, dob);
        this.episodesCount = episodesCount;
        this.averagelength = averagelength;
    }

    public int getEpisodesCount() {
        return episodesCount;
    }

    public void setEpisodesCount(int episodesCount) {
        this.episodesCount = episodesCount;
    }

    public double getAveragelength() {
        return averagelength;
    }

    public void setAveragelength(double averagelength) {
        this.averagelength = averagelength;
    }

    @Override
    public void myMethod() {
        super.myMethod();
        System.out.println("Lớp con : Serial");
    }

    @Override
    public String toString() {
        return super.toString() + " - " + episodesCount + " - " + averagelength;
    }
}
