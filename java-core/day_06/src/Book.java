public class Book {
    public int id;
    public String title;
    public String description;
    public String author;
    public int year;

    public Book() {
        System.out.println("Constructor mặc định");
    }

    public Book(int id, String title, String description, String author, int year) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.year = year;
    }
}