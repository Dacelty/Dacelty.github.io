public class Book {
    public int id;
    public String title;
    public String author;
    public String category;
    public String company;
    public int year;

    public Book() {
    }

    public Book(int id, String title, String author, String category, String company, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.company = company;
        this.year = year;
    }
}
