package th.com.example.springTHMVC.model2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private int id;
    @NotBlank(message = "job not null")
    private String name;
}
