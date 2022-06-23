package org.example;
import java.util.*;



public class Service {
    public void findBookByTitle(ArrayList<Book> list, String fName){
        int count = 0;
        for (Book b : list){
            if (b.getTitle().contains(fName)){
                count++;
                System.out.println(b.getId() + " - " + b.getTitle() + " - " + Arrays.toString(b.getCategory()) + " - " + b.getAuthor() + " - " + b.getPage_number() + " - " + b.getRelease_year());
            }
        }
        if (count == 0){
            System.out.println("Không tìm thầy sách này.");
        }
    }

    public void findBookByCategory(ArrayList<Book> list, String fCategory){
        int count = 0;
        for (Book b : list){
            if (Arrays.toString(b.getCategory()).contains(fCategory)){
                count++;
                System.out.println(b.getId() + " - " + b.getTitle() + " - " + Arrays.toString(b.getCategory()) + " - " + b.getAuthor() + " - " + b.getPage_number() + " - " + b.getRelease_year());
            }
        }
        if (count == 0){
            System.out.println("Không tìm thầy sách này.");
        }
    }

    public void sxSachTheoSoTrang(ArrayList<Book> list){
        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPage_number() - o2.getPage_number();
            }
        });
    }

    public void sxSachTheoNamXuatBan(ArrayList<Book> list){
        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getRelease_year() - o2.getRelease_year();
            }
        });
    }

}
