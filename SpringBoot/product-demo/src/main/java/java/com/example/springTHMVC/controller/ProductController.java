package java.com.example.springTHMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import java.com.example.springTHMVC.exception2.StorageException;
import java.com.example.springTHMVC.model2.Product;
import java.com.example.springTHMVC.repostory.CategoryRepository;
import java.com.example.springTHMVC.repostory.ProductRepository;
import java.com.example.springTHMVC.service.StorageService;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private StorageService storageService;
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired private MessageSource messageSource;


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("product",new Product());
        model.addAttribute("categories",categoryRepo.getAll());
        return "home";
    }

    @GetMapping("/listAll")
    public String listAll(Model model) {
        List<Product> products = productRepo.getAll();

        model.addAttribute("products", products);

        return "listAll";
    }

    @PostMapping(value = "/post", consumes = {"multipart/form-data"})
    public String postInfo(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model) throws Exception {
        Locale locale = LocaleContextHolder.getLocale();
        if (product.getPhoto().getOriginalFilename().isEmpty()) {
            result.addError(new FieldError("product", "photo",
                    messageSource.getMessage("photo.required", null, "Photo required", locale)));
        }
        if (result.hasErrors()) {
            model.addAttribute("categories",categoryRepo.getAll());
            return "home";
        }

        if (product.getId() > 0) {
            productRepo.edit(product);
        } else {
            productRepo.create(product);
        }
        storageService.uploadFile(product.getPhoto(), product.getId());
        model.addAttribute("products", productRepo.getAll());
        return "redirect:/listAll";

    }

    @GetMapping("/product/{id}")
    public String personInfo(@PathVariable("id")int id, Model model){
        Optional<Product> product = productRepo.get(id);
        if(product.isPresent()){
            model.addAttribute("product",product.get());
            return "productInfo";
        }
        return "home";
    }

    @GetMapping("/product/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model) {
        Optional<Product> product = productRepo.get(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
        }
        return "productForm";
    }

    @GetMapping("/product/delete/{id}")
    public String deletePerson(@PathVariable("id") int id, Model model) {
        storageService.deleteFile(id);
        productRepo.deleteById(id);
        model.addAttribute("product", productRepo.getAll());
        return "redirect:/listAll";
    }

    @ExceptionHandler(StorageException.class)
    public String handleStorageFileNotFound(StorageException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "failure";
    }

}
