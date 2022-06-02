package bstorm.akimts.mvc.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long nombreDeLits;

    @ManyToOne
    private Hotel hotel;
}
