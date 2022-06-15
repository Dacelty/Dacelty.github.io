public class Main {
    public static void main(String[] args) {
        BookService service = new BookService();
        Book newBook = service.addBook();
    }
}