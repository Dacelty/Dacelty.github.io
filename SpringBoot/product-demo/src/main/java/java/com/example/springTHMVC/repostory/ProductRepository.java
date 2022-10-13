package java.com.example.springTHMVC.repostory;

import org.springframework.stereotype.Repository;
import java.com.example.springTHMVC.model2.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public List<Product> getAll(){return this.products;}

    public Product create(Product product){
        int id;
        if (products.isEmpty()) {
            id = 1;
        } else {
            Product lastProduct = products.get(products.size() - 1);
            id = lastProduct.getId() + 1;
        }
        product.setId(id);
        products.add(product);
        return product;
    }

    public Product edit(Product product){
        var optionalProduct = get(product.getId());

        if(optionalProduct.isPresent()){
            var existProduct = optionalProduct.get();
            existProduct.setName(product.getName());
            existProduct.setCategory(product.getCategory());
            existProduct.setDetail(product.getDetail());

            if(!product.getPhoto().getOriginalFilename().isEmpty())
                existProduct.setPhoto(product.getPhoto());
            return existProduct;
        }
        return null;
    }


    public Optional<Product> get(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst();
    }

    public void deleteById(int id) {
        get(id).ifPresent(existed -> products.remove(existed));
    }

}
