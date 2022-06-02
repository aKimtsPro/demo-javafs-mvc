package bstorm.akimts.mvc.repository;

import bstorm.akimts.mvc.models.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}
