import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service s = new Service();
        Scanner scanner = new Scanner(System.in);

        Movie[] arrMovies = s.getallmovies();
        System.out.println("Danh sách Movie:");
        s.show(arrMovies);
        System.out.println();
        Serial[] arrSer = s.getallserials();
        System.out.println("Danh sách Serial:");
        s.show(arrSer);

        System.out.println();

        System.out.println("Nhập tên phim cần tìm:");
        String fName = scanner.nextLine();
        System.out.println("Phìm cần tìm là:");
        s.findMovieByName(arrMovies,fName);
    }
}
