package java.com.example.springTHMVC.model2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private int id;
    @NotBlank(message = "category not null")
    private String name;
}
