package java.com.example.springTHMVC.model2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    @Size(min=3, max=30,message = "name size between 10 and 30")
    private String name;
    @NotBlank(message = "job not null")
    private String job;
    private LocalDate birthdate;
    private MultipartFile photo;

}
