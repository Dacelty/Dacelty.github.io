import java.time.LocalDate;

public class Film {
    private int id;
    private String name;
    private String genre;
    private String director;
    private LocalDate dob;

    public Film(int id, String name, String genre, String director, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.dob = dob;
    }

    public Film() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + genre + " - " + director + " - " + dob;
    }

    public void myMethod(){
        System.out.println("Lớp cha");
    }
}
