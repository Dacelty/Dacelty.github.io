import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.ParseException;




public class Service {

    public ArrayList<Movie> getallmovies() {
        ArrayList<Movie> arrMovies = new ArrayList<>();

        arrMovies.add(new Movie(1,"ABC1","Comedy","113",LocalDate.of(1990,12,3),120));
        arrMovies.add(new Movie(2,"ABC1","Comedy","113",LocalDate.of(1990,12,3),120));
        arrMovies.add(new Movie(3,"ABC1","Comedy","113",LocalDate.of(1990,12,3),120));
        arrMovies.add(new Movie(4,"ABC1","Comedy","113",LocalDate.of(1990,12,3),120));
        arrMovies.add(new Movie(5,"ABC1","Comedy","113",LocalDate.of(1990,12,3),120));

        return arrMovies;
    }

    public ArrayList<Serial> getallserials(){
        ArrayList<Serial> arrSer = new ArrayList<>();

        arrSer.add(new Serial(1,"ABC1","Comedy","113",LocalDate.of(1990,12,3),3,120));
        arrSer.add(new Serial(2,"ABC1","Comedy","113",LocalDate.of(1990,12,3),3,120));
        arrSer.add(new Serial(3,"ABC1","Comedy","113",LocalDate.of(1990,12,3),3,120));
        arrSer.add(new Serial(4,"ABC1","Comedy","113",LocalDate.of(1990,12,3),3,120));
        arrSer.add(new Serial(5,"ABC1","Comedy","113",LocalDate.of(1990,12,3),3,120));

        return arrSer;
    }

    public void addMovie(ArrayList<Movie> listMovies) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID:");
        int newID = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên Movie:");
        String newMovie = scanner.nextLine();
        System.out.println("Nhập thể loại:");
        String newGenre = scanner.nextLine();
        System.out.println("Nhập đạo diễn:");
        String newDirector = scanner.nextLine();

        System.out.println("Nhập ngày công chiếu:");
        System.out.println("DD/MM/YYYY");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = scanner.nextLine();
        LocalDate newDob = LocalDate.parse(date, format);

        System.out.println("Nhập thời lượng:");
        double newLength = scanner.nextDouble();

        Movie newAddedMovie = new Movie(newID,newMovie,newGenre,newDirector,newDob,newLength);
        listMovies.add(newAddedMovie);

    }

    public void addSerial(ArrayList<Serial> listSer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID:");
        int newID = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên Movie:");
        String newMovie = scanner.nextLine();
        System.out.println("Nhập thể loại:");
        String newGenre = scanner.nextLine();
        System.out.println("Nhập đạo diễn:");
        String newDirector = scanner.nextLine();

        System.out.println("Nhập ngày công chiếu:");
        System.out.println("DD/MM/YYYY");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = scanner.nextLine();
        LocalDate newDob = LocalDate.parse(date, format);

        System.out.println("Nhập số tập:");
        int newEpisodeCount = scanner.nextInt();
        System.out.println("Nhập thời lượng trung bình: ");
        double newAverageLength = scanner.nextDouble();

        Serial newAddedSer = new Serial(newID,newMovie,newGenre,newDirector,newDob,newEpisodeCount,newAverageLength);
        listSer.add(newAddedSer);

    }

    public void findMovieByName(ArrayList<Movie> arr, String fName){
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
