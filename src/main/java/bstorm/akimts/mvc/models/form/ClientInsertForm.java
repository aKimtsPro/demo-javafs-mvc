package bstorm.akimts.mvc.models.form;

import bstorm.akimts.mvc.models.entity.Client;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ClientInsertForm {

    @NotBlank @Size(min = 5, max = 20)
    private String username;
    @NotBlank @Size(min = 10)
    private String password;
    @NotBlank @Email
    private String email;
    @NotNull @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateNaissance;
    @Min(0) @Max(100)
    private int satisfaction = 50;

    public Client toEntity(){
        Client c = new Client();
        c.setUsername(username);
        c.setPassword(password);
        c.setDateNaissance(dateNaissance);
        c.setSatisfaction(satisfaction);
        c.setEmail(email);
        return c;
    }

}
