package bstorm.akimts.mvc.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "hotel")
    private List<Chambre> chambres;

    public Hotel(String nom, String adresse, int nbrEtoiles) {
        this.nom = nom;
        this.adresse = adresse;
        this.nbrEtoiles = nbrEtoiles;
    }
}
