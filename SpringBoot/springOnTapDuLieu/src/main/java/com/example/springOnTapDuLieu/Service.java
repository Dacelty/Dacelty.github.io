package com.example.springOnTapDuLieu;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Component
public class Service {
    public void sxTheoNameAsc(ArrayList<Person> list){
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void sxTheoNameDesc(ArrayList<Person> list){
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
    }

    public void sxTheoNatAsc(ArrayList<Person> list){
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getNationality().compareTo(o2.getNationality());
            }
        });
    }

    public void sxTheoNatDesc(ArrayList<Person> list){
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getNationality().compareTo(o1.getNationality());
            }
        });
    }

    public void sxTheoAgeAsc(ArrayList<Person> list){
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return (int) (o1.getAge() - o2.getAge());
            }
        });
    }

    public void sxTheoAgeDesc(ArrayList<Person> list){
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return (int) (o2.getAge() - o1.getAge());
            }
        });
    }

}
