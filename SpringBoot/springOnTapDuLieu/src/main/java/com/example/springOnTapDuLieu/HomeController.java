package com.example.springOnTapDuLieu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class HomeController {
    @Autowired
    private Repo repo;


    @GetMapping()
    public ArrayList<Person> getJsonPpl(){
        return repo.Repo();
    }

    @GetMapping("/people")
    @ResponseBody
    public ArrayList<Person> sortPpl(@RequestParam String sort ,@RequestParam String direction){
        switch(sort){
            case "name":
                if(direction.equals("asc")){
                    return repo.sxTheoNameAsc();
                } else if(direction.equals("desc")){
                    return repo.sxTheoNameDesc();
                } else {
                    System.out.println("Sai cú pháp.");
                    return null;
                }
            case "nationality":
                if(direction.equals("asc")){
                    return repo.sxTheoNatAsc();
                } else if(direction.equals("desc")){
                    return repo.sxTheoNatDesc();
                } else {
                    System.out.println("Sai cú pháp.");
                    return null;
                }
            case "age":
                if(direction.equals("asc")){
                    return repo.sxTheoAgeAsc();
                } else if(direction.equals("desc")){
                    return repo.sxTheoAgeDesc();
                } else {
                    System.out.println("Sai cú pháp.");
                    return null;
                }
            default:
                System.out.println("Sai cú pháp");
                return null;
        }

    }


}
