package com.example.springCRUDThymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class TLController {
    private CustomerRepo cRepo;

    public TLController(){
        cRepo = new CustomerRepo();
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/listAll")
    public String listAll(Model model) {
        List<Customer> cust = cRepo.getAll();

        model.addAttribute("cust", cust);
        return "listAll";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("cust1", new Customer());
        return "cust1Form";
    }

    @PostMapping("/post")
    public String postInfo(@ModelAttribute("cust1") Customer cust1, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            if(cust1.getId()>0){
                cRepo.edit(cust1);
            }else{
                cRepo.create(cust1);
            }
            model.addAttribute("cust", cRepo.getAll());
            return "redirect:/listAll";
        }
        return "cust1Form";
    }

    @GetMapping("/cust1/edit/{id}")
    public String editCust(@PathVariable("id") int id, Model model) {
        Optional<Customer> cust1 = cRepo.get(id);
        if(cust1.isPresent()){
            model.addAttribute("cust1",cust1);
        }
        return "cust1Form";
    }



    @GetMapping("/cust1/delete/{id}")
    public String deleteCust(@PathVariable("id") int id, Model model){
        cRepo.deleteById(id);
        model.addAttribute("cust",cRepo.getAll());
        return "redirect:/listAll";
    }

    @GetMapping("/search")
    public String searchCustName(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        if(name==""){
            model.addAttribute("cust",cRepo.getAll());
            return "redirect:/listAll";
        }
        else{
            Customer cust1 = cRepo.search(name);
            model.addAttribute("cust",cust1);
            return "listAll";
        }
    }

    @GetMapping("/search/email")
    public String searchCustEmail(HttpServletRequest request, Model model){
        String email = request.getParameter("email");
        if(email==""){
            model.addAttribute("cust",cRepo.getAll());
            return "redirect:/listAll";
        }
        else{
            Customer cust1 = cRepo.searchEmail(email);
            model.addAttribute("cust",cust1);
            return "listAll";
        }
    }

    @GetMapping("/sortAsc")
    public String sortByNameAsc(Model model) {
        List<Customer> cust = cRepo.getAll();
        cust.sort((o1, o2) -> o1.getFullname().compareTo(o2.getFullname()));
        model.addAttribute("cust", cust);
        return "listAll";
    }

    @GetMapping("/sortDesc")
    public String sortByNameDesc(Model model) {
        List<Customer> cust = cRepo.getAll();
        cust.sort((o1, o2) -> o2.getFullname().compareTo(o1.getFullname()));
        model.addAttribute("cust", cust);
        return "listAll";
    }

    @GetMapping("/listAll/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        Customer cust1 = cRepo.get(id).get();
        model.addAttribute("cust",cust1);
        return "detail";
    }

    //Su dung form rieng de edit
    @GetMapping("/edit/{id}")
    public String editCust2(@PathVariable("id") Integer id, Model model){
        model.addAttribute("cust1",cRepo.get(id).get());
        return "editform";
    }


    // Su dung form rieng de edit
    @PostMapping("/update")
    public String update(Customer cust1,BindingResult result, Model model){
        if(!result.hasErrors()){
            cRepo.edit(cust1);
            model.addAttribute("cust",cRepo.getAll());
            return "redirect:/listAll";
        }
        return "editform";
    }


}
