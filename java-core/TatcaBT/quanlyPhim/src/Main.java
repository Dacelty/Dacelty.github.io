import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service s = new Service();
        Scanner scanner = new Scanner(System.in);

        Movie movie = new Movie();
        Movie[] arrMovies = s.getallmovies();
        movie.myMethod();
        s.show(arrMovies);

        System.out.println();

        Serial serial = new Serial();
        Serial[] arrSer = s.getallserials();
        serial.myMethod();
        s.show(arrSer);

        System.out.println();

        System.out.println("Nhập tên phim cần tìm:");
        String fName = scanner.nextLine();
        System.out.println("Phim cần tìm là:");
        s.findMovieByName(arrMovies,fName);
    }
}
