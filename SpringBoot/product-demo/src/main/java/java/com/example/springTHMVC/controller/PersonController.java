package java.com.example.springTHMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.com.example.springTHMVC.exception.StorageException;
import java.com.example.springTHMVC.model2.Person;
import java.com.example.springTHMVC.repostory.JobRepository;
import java.com.example.springTHMVC.repostory.PersonRepository;
import java.com.example.springTHMVC.service.StorageService;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private StorageService storageService;
    @Autowired
    private JobRepository jobRepository;
    @Autowired private MessageSource messageSource;


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("product",new Person());
        model.addAttribute("categories",jobRepository.getAll());
        return "home";
    }

    @GetMapping("/listAll")
    public String listAll(Model model) {
        List<Person> products = personRepository.getAll();

        model.addAttribute("products", products);

        return "listAll";
    }

    @PostMapping(value = "/post", consumes = {"multipart/form-data"})
    public String postInfo(@Valid @ModelAttribute("product") Person person, BindingResult result, Model model) throws Exception {
        Locale locale = LocaleContextHolder.getLocale();
        if (person.getPhoto().getOriginalFilename().isEmpty()) {
            result.addError(new FieldError("product", "photo",
                    messageSource.getMessage("photo.required", null, "Photo required", locale)));
        }
        if (result.hasErrors()) {
            model.addAttribute("categories",jobRepository.getAll());
            return "home";
        }

        if (person.getId() > 0) {
            personRepository.edit(person);
        } else {
            personRepository.create(person);
        }
        storageService.uploadFile(person.getPhoto(), person.getId());
        model.addAttribute("products", personRepository.getAll());
        return "redirect:/listAll";

    }

    @GetMapping("/product/{id}")
    public String personInfo(@PathVariable("id")int id, Model model){
        Optional<Person> product = personRepository.get(id);
        if(product.isPresent()){
            model.addAttribute("product",product.get());
            return "productInfo";
        }
        return "home";
    }

    @GetMapping("/product/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model) {
        Optional<Person> product = personRepository.get(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
        }
        return "productForm";
    }

    @GetMapping("/product/delete/{id}")
    public String deletePerson(@PathVariable("id") int id, Model model) {
        storageService.deleteFile(id);
        personRepository.deleteById(id);
        model.addAttribute("product", personRepository.getAll());
        return "redirect:/listAll";
    }

    @ExceptionHandler(StorageException.class)
    public String handleStorageFileNotFound(StorageException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "failure";
    }
}
