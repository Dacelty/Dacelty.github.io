package java.com.example.springTHMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.com.example.springTHMVC.model2.Job;
import java.com.example.springTHMVC.repostory.JobRepository;
import java.util.Optional;

@Controller
public class JobController {
    @Autowired
    private JobRepository jobRepository;

    @GetMapping("/listCategory")
    public String getAllJob(Model model){
        model.addAttribute("cats", jobRepository.getAll());
        return "catList";
    }

    //Job Form
    @GetMapping("/addCategory")
    public String addJob(Model model){
        model.addAttribute("cat",new Job());
        return "catForm";
    }

    //Them job
    @PostMapping("/addCategory")
    public String addJob(@Valid @ModelAttribute("cat")Job cat, BindingResult result, Model model){

        if(result.hasErrors()){
            return "catForm";
        }
        if (cat.getId() > 0) {
            jobRepository.edit(cat);
            model.addAttribute("cats", jobRepository.getAll());
            return "catList";
        } else {
            Job newCat = jobRepository.create(cat);
            if(newCat!=null){
                model.addAttribute("cats", jobRepository.getAll());
                return "catList";
            }
            model.addAttribute("error","Job already exist");
            return "catForm";
        }

    }

    //Cap nhat Job
    @GetMapping("/cat/edit/{id}")
    public String editJob(@PathVariable("id") int id, Model model) {
        Optional<Job> cat = jobRepository.get(id);
        if (cat.isPresent()) {
            model.addAttribute("cat", cat.get());
        }
        return "catForm";
    }

    //Xoa job
    @GetMapping("/cat/delete/{id}")
    public String deleteJob(@PathVariable("id") int id, Model model) {
        jobRepository.deleteById(id);
        model.addAttribute("cats", jobRepository.getAll());
        return "catList";
    }
}
