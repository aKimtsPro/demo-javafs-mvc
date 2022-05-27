package bstorm.akimts.mvc.models.form;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
public class FakeForm {


    @NotBlank
    @Size(min = 5, max = 20, message = "message d'erreur lié")
    @Pattern(regexp = "")
    @Email
    private String chaine;

    @Min(1) @Max(5)
    @Positive
    @Negative
    @PositiveOrZero
    @NegativeOrZero
    private int nombre;

    @Future
    @Past
    @FutureOrPresent
    @PastOrPresent
    private LocalDate date;

    @AssertTrue
    @AssertFalse
    private boolean aBoolean;

    @NotNull
    private Object objet;

    private List<Object> list;

}
