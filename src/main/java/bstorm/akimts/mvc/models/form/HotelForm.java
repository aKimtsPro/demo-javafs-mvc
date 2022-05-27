package bstorm.akimts.mvc.models.form;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class HotelForm {

    private String nom;
    private String adresse;
    @Min(1) @Max(5)
    private int nbrEtoiles;

}
