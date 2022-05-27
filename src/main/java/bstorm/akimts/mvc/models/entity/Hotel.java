package bstorm.akimts.mvc.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;
    private String adresse;
    private int nbrEtoiles;

    public Hotel(String nom, String adresse, int nbrEtoiles) {
        this.nom = nom;
        this.adresse = adresse;
        this.nbrEtoiles = nbrEtoiles;
    }
}
