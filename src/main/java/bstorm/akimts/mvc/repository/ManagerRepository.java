package bstorm.akimts.mvc.repository;

import bstorm.akimts.mvc.models.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
