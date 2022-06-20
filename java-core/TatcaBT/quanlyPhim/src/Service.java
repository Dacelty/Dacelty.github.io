import java.time.LocalDate;

public class Service {

    public Movie[] getallmovies() {
        Movie[] arrMovies = new Movie[5];

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

    public Serial[] getallserials(){
        Serial[] arrSer = new Serial[5];

        arrSer[0] = new Serial();
        arrSer[0].setId(1);
        arrSer[0].setName("ABC1");
        arrSer[0].setGenre("Comedy");
        arrSer[0].setDirector("113");
        arrSer[0].setDob(LocalDate.of(1990,12,3));
        arrSer[0].setEpisodesCount(3);
        arrSer[0].setAveragelength(120);

        arrSer[1] = new Serial();
        arrSer[1].setId(2);
        arrSer[1].setName("ABC2");
        arrSer[1].setGenre("Comedy");
        arrSer[1].setDirector("113");
        arrSer[1].setDob(LocalDate.of(1990,12,3));
        arrSer[1].setEpisodesCount(3);
        arrSer[1].setAveragelength(120);

        arrSer[2] = new Serial();
        arrSer[2].setId(3);
        arrSer[2].setName("ABC3");
        arrSer[2].setGenre("Comedy");
        arrSer[2].setDirector("113");
        arrSer[2].setDob(LocalDate.of(1990,12,3));
        arrSer[2].setEpisodesCount(3);
        arrSer[2].setAveragelength(120);

        arrSer[3] = new Serial();
        arrSer[3].setId(4);
        arrSer[3].setName("ABC4");
        arrSer[3].setGenre("Comedy");
        arrSer[3].setDirector("113");
        arrSer[3].setDob(LocalDate.of(1990,12,3));
        arrSer[3].setEpisodesCount(3);
        arrSer[3].setAveragelength(120);

        arrSer[4] = new Serial();
        arrSer[4].setId(5);
        arrSer[4].setName("ABC4");
        arrSer[4].setGenre("Comedy");
        arrSer[4].setDirector("113");
        arrSer[4].setDob(LocalDate.of(1990,12,3));
        arrSer[4].setEpisodesCount(3);
        arrSer[4].setAveragelength(120);

        return  arrSer;
    }

    public void show(Movie[] arr){
        for (Movie b : arr){
            System.out.println(b.getId() + " - " + b.getName() + " - " + b.getGenre() + " - " + b.getDirector() + " - " + b.getDob() + " - " + b.getLength());
        }
    }

    public void show(Serial[] arr){
        for (Serial b : arr){
            System.out.println(b.getId() + " - " + b.getName() + " - " + b.getGenre() + " - " + b.getDirector() + " - " + b.getDob() + " - " + b.getEpisodesCount() + " - " + b.getAveragelength());
        }
    }

    public void findMovieByName(Movie[] arr, String fName){
        int count = 0;
        for (Movie b : arr){
            if (b.getName().contains(fName)){
                count++;
                System.out.println(b.getId() + " - " + b.getName() + " - " + b.getGenre() + " - " + b.getDirector() + " - " + b.getDob() + " - " + b.getLength());
            }
        }
        if (count == 0){
            System.out.println("Không tìm thấy phim nào có tên này.");
        }
    }
}
