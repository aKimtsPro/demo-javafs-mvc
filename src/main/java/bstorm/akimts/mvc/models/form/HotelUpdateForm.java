package bstorm.akimts.mvc.models.form;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class HotelUpdateForm {

    private String nom = "default";
    @Min(2) @Max(5)
    private int nbrEtoiles;

}
