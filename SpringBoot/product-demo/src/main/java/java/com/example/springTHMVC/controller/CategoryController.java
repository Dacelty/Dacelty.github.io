package java.com.example.springTHMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.com.example.springTHMVC.model2.Category;
import java.com.example.springTHMVC.repostory.CategoryRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping("/listCategory")
    public String getAllJob(Model model){
        model.addAttribute("cats",categoryRepo.getAll());
        return "catList";
    }

    //Job Form
    @GetMapping("/addCategory")
    public String addJob(Model model){
        model.addAttribute("cat",new Category());
        return "catForm";
    }

    //Them job
    @PostMapping("/addCategory")
    public String addJob(@Valid @ModelAttribute("cat")Category cat, BindingResult result, Model model){

        if(result.hasErrors()){
            return "catForm";
        }
        if (cat.getId() > 0) {
            categoryRepo.edit(cat);
            model.addAttribute("cats",categoryRepo.getAll());
            return "catList";
        } else {
            Category newCat = categoryRepo.create(cat);
            if(newCat!=null){
                model.addAttribute("cats",categoryRepo.getAll());
                return "catList";
            }
            model.addAttribute("error","Category already exist");
            return "catForm";
        }

    }

    //Cap nhat Job
    @GetMapping("/cat/edit/{id}")
    public String editJob(@PathVariable("id") int id, Model model) {
        Optional<Category> cat = categoryRepo.get(id);
        if (cat.isPresent()) {
            model.addAttribute("cat", cat.get());
        }
        return "catForm";
    }

    //Xoa job
    @GetMapping("/cat/delete/{id}")
    public String deleteJob(@PathVariable("id") int id, Model model) {
        categoryRepo.deleteById(id);
        model.addAttribute("cats", categoryRepo.getAll());
        return "catList";
    }
}
