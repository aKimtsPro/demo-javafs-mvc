package bstorm.akimts.mvc.models.form;

import bstorm.akimts.mvc.models.entity.Chambre;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;

@Data
public class ChambreInsertForm {

    @Positive(message = "le nombre de lit devrait être positif")
    @Max(value = 10, message = "il ne peut y avoir que 10 lits au maximum")
    private int nbrLits;
    private long hotelId;

    public Chambre toEntity(){

        Chambre entity = new Chambre();
        entity.setNombreDeLits(nbrLits);
        return entity;

    }

}
