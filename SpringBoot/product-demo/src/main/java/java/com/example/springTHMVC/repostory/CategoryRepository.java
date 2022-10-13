package java.com.example.springTHMVC.repostory;

import org.springframework.stereotype.Repository;
import java.com.example.springTHMVC.model2.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Repository
public class CategoryRepository {
    private List<Category> categories = new ArrayList<>();

    public CategoryRepository() {
        List<Category> list = Arrays.asList(
                new Category(1,"Electronics"),
                new Category(2,"Household"),
                new Category(3,"Clothes")
        );
        categories.addAll(list);
    }

    public List<Category> getAll() {
        return categories;
    }

    public Category create(Category cat){
        int id;
        if (categories.isEmpty()) {
            id = 1;
        } else {
            Category lastcat = categories.get(categories.size() - 1);
            id = lastcat.getId() + 1;
        }
        cat.setId(id);
        for(Category c:categories){
            if(c.getName().equalsIgnoreCase(cat.getName()))
                return null;
        }
        categories.add(cat);
        return cat;
    }

    public Category edit(Category cat){
        get(cat.getId()).ifPresent(existCat->{
            existCat.setName(cat.getName());
        });
        return cat;
    }

    public Optional<Category> get(int id) {
        return categories.stream().filter(c -> c.getId() == id).findFirst();
    }

    public void deleteById(int id) {
        get(id).ifPresent(existed -> categories.remove(existed));
    }
}
