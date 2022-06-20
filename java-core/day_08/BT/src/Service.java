import java.time.LocalDate;

public class Service {
    public Movie[] getallmovies() {
        Movie[] arrMovies = new Movie[5];
//        arrMovies[0] = new Movie("1","ABC1","Comedy","113",LocalDate.of(1990,12,3));
//        arrMovies[1] = new Movie("2","ABC2","Comedy/Horror","114",LocalDate.of(1992,12,3));
//        arrMovies[2] = new Movie("3","ABC3","Action","115",LocalDate.of(1995,12,3));
//        arrMovies[3] = new Movie("4","ABC4","Thriller","115",LocalDate.of(1996,12,3));
//        arrMovies[4] = new Movie("5","ABC5","Comedy","113",LocalDate.of(1999,12,3));
        arrMovies[0] = new Movie();
        arrMovies[0].setId(1);
        arrMovies[0].setName("ABC1");
        arrMovies[0].setGenre("Comedy");
        arrMovies[0].setDirector("113");
        arrMovies[0].setDob(LocalDate.of(1990,12,3));
        arrMovies[0].setLength(120);

        arrMovies[1] = new Movie();
        arrMovies[1].setId(2);
        arrMovies[1].setName("ABC2");
        arrMovies[1].setGenre("Comedy");
        arrMovies[1].setDirector("113");
        arrMovies[1].setDob(LocalDate.of(1990,12,3));
        arrMovies[1].setLength(120);

        arrMovies[2] = new Movie();
        arrMovies[2].setId(3);
        arrMovies[2].setName("ABC3");
        arrMovies[2].setGenre("Comedy");
        arrMovies[2].setDirector("113");
        arrMovies[2].setDob(LocalDate.of(1990,12,3));
        arrMovies[2].setLength(120);

        arrMovies[3] = new Movie();
        arrMovies[3].setId(4);
        arrMovies[3].setName("ABC4");
        arrMovies[3].setGenre("Comedy");
        arrMovies[3].setDirector("113");
        arrMovies[3].setDob(LocalDate.of(1990,12,3));
        arrMovies[3].setLength(120);

        arrMovies[4] = new Movie();
        arrMovies[4].setId(5);
        arrMovies[4].setName("ABC4");
        arrMovies[4].setGenre("Comedy");
        arrMovies[4].setDirector("113");
        arrMovies[4].setDob(LocalDate.of(1990,12,3));
        arrMovies[4].setLength(120);

        return arrMovies;
    }

    public void show(Movie[] arr){
        for (Movie b : arr){
            System.out.println(b.getId() + " - " + b.getName() + " - " + b.getGenre() + " - " + b.getDirector() + " - " + b.getDob() + " - " + b.getLength());
        }
    }
}
