import java.util.*;

public class Main {


    public static void main(String[] args) {
        Service s = new Service();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Movie> listMovies;
        ArrayList<Serial> listSerials;

        System.out.println("Danh sách Movie: ");
        listMovies = s.getallmovies();
        MyGeneric.printArray(listMovies);
        System.out.println();

        System.out.println("Danh sách Serial: ");
        listSerials = s.getallserials();
        MyGeneric.printArray(listSerials);
        System.out.println();

        System.out.println("Lựa chọn thêm phim mới:");
        System.out.println("1 - Movie");
        System.out.println("2 - Serial");
        int tpm = scanner.nextInt();


        switch (tpm) {
            case 1:
                s.addMovie(listMovies);
                System.out.println("Danh sách Movie sau khi thêm: ");
                MyGeneric.printArray(listMovies);
                break;
            case 2:
                s.addSerial(listSerials);
                System.out.println("Danh sách Serial sau khi thêm: ");
                MyGeneric.printArray(listSerials);
                break;
        }

        System.out.println("Nhận tên phim cần tìm:");
        String fName = scanner.nextLine();
        MyGeneric.findMovieByName(listMovies, fName);



    }
}
