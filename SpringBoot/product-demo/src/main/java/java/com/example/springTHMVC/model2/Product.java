package java.com.example.springTHMVC.model2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    @Size(min=3, max=30,message = "name size between 3 and 30")
    private String name;
    @NotBlank(message = "category not null")
    private String category;
    @NotBlank(message = "detail not null")
    private String detail;
    private MultipartFile photo;
}

