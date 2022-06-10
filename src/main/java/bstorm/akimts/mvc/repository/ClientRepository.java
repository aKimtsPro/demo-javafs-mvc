package bstorm.akimts.mvc.repository;


import bstorm.akimts.mvc.models.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
