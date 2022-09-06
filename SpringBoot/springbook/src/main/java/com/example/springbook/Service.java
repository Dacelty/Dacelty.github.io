package com.example.springbook;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class Service {
    public void sxSachTheoAuthor(ArrayList<Book> list){
        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getAuthor().compareTo(o2.getAuthor());
            }
        });
    }

    public void sxSachTheoTitle(ArrayList<Book> list){
        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
    }

    public void sxSachTheoYear(ArrayList<Book> list){
        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getYear() - o2.getYear();
            }
        });
    }


}
