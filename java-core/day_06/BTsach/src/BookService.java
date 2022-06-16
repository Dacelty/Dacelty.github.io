public class BookService {
    public Book[] getAllBooks() {
        Book[] arrBook = new Book[5];
        arrBook[0] = new Book(1,"abc","xyz","Drama","Kim Đồng",2000);
        arrBook[1] = new Book(1,"abc","xyz","Action","Kim Đồng",2001);
        arrBook[2] = new Book(1,"abc","xyz","Horror","Kim Đồng",2022);
        arrBook[3] = new Book(1,"abc","xyz","Comedy","Kim Đồng",1995);
        arrBook[4] = new Book(1,"abc","xyz","Mystery","Kim Đồng",2004);

        return arrBook;
    }

    public void show(Book[] arr){
        for (Book b : arr){
            System.out.println(b.id + " - " + b.title + " - " + b.author + " - " + b.category + " - " + b.company + " - " + b.year);
        }
    }

    public void findBookByName(Book[] arr, String fName){
        int count = 0;
        for (Book b : arr){
            if (b.title.contains(fName)){
                count++;
                System.out.println(b.id + " - " + b.title + " - " + b.author + " - " + b.category + " - " + b.company + " - " + b.year);
            }
        }
        if (count == 0){
            System.out.println("Không tìm thầy sách này.");
        }
    }

    public void findBookByYear(Book[] arr, int year){
        int count = 0;
        for (Book b : arr){
            if (b.year == year){
                count++;
                System.out.println(b.id + " - " + b.title + " - " + b.author + " - " + b.category + " - " + b.company + " - " + b.year);
            }
        }
        if (count == 0){
            System.out.println("Không có sách nào xuất bản trong năm nay.");
        }
    }

    public void findBookByCategory(Book[] arr, String cName){
        int count = 0;
        for (Book b : arr){
            if (b.category.contains(cName)){
                count++;
                System.out.println(b.id + " - " + b.title + " - " + b.author + " - " + b.category + " - " + b.company + " - " + b.year);
            }
        }
        if (count == 0){
            System.out.println("Không có sách nào trong thể loại này");
        }
    }
}
