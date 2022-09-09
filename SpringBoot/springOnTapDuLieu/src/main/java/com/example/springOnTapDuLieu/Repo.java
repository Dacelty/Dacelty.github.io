package com.example.springOnTapDuLieu;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class Repo {
    private ArrayList<Person> per =new ArrayList<Person>();

    public ArrayList<Person> Repo(){
        try {
            File file = ResourceUtils.getFile("src/main/resources/MOCK_DATA.json");
            ObjectMapper mapper = new ObjectMapper();
            per.addAll(mapper.readValue(file, new TypeReference<List<Person>>() {}));
//            car.forEach(System.out::println);
            for (Person p:per){
                System.out.println(p.getName() + " - " + p.getNationality() + " - " + p.getAge());
            }
            System.out.println("Đọc dữ liệu từ file thành công.");
            return per;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Person> sxTheoNameAsc(){
        Collections.sort(per, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Person p:per){
            System.out.println(p.getName() + " - " + p.getNationality() + " - " + p.getAge());
        }
        System.out.println("Sort thành công.");
        return per;
    }

    public ArrayList<Person> sxTheoNameDesc(){
        Collections.sort(per, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
        for (Person p:per){
            System.out.println(p.getName() + " - " + p.getNationality() + " - " + p.getAge());
        }
        System.out.println("Sort thành công.");
        return per;
    }

    public ArrayList<Person> sxTheoNatAsc(){
        Collections.sort(per, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getNationality().compareTo(o2.getNationality());
            }
        });
        for (Person p:per){
            System.out.println(p.getName() + " - " + p.getNationality() + " - " + p.getAge());
        }
        System.out.println("Sort thành công.");
        return per;
    }

    public ArrayList<Person> sxTheoNatDesc(){
        Collections.sort(per, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getNationality().compareTo(o1.getNationality());
            }
        });
        for (Person p:per){
            System.out.println(p.getName() + " - " + p.getNationality() + " - " + p.getAge());
        }
        System.out.println("Sort thành công.");
        return per;
    }

    public ArrayList<Person> sxTheoAgeAsc(){
        Collections.sort(per, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return (int) (o1.getAge() - o2.getAge());
            }
        });
        for (Person p:per){
            System.out.println(p.getName() + " - " + p.getNationality() + " - " + p.getAge());
        }
        System.out.println("Sort thành công.");
        return per;
    }

    public ArrayList<Person> sxTheoAgeDesc(){
        Collections.sort(per, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return (int) (o2.getAge() - o1.getAge());
            }
        });
        for (Person p:per){
            System.out.println(p.getName() + " - " + p.getNationality() + " - " + p.getAge());
        }
        System.out.println("Sort thành công.");
        return per;
    }
}
