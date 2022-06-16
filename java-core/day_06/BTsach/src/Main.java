import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookService service = new BookService();
        Book[] arrBook = service.getAllBooks();
        System.out.println("Danh sách");
        service.show(arrBook);

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên sách cần tìm:");
        String fName = sc.nextLine();
        System.out.println("Sách cần tìm là: ");
        service.findBookByName(arrBook, fName);
        System.out.println("Nhập thể loại sách cần tìm:");
        String cName = sc.nextLine();
        System.out.println("Sách cần tìm là: ");
        service.findBookByCategory(arrBook, cName);

        System.out.println("Sách xuất bản trong năm nay là: ");
        service.findBookByYear(arrBook, 2022);
    }
}
