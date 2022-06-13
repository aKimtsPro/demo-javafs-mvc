package bstorm.akimts.mvc.repository;

import bstorm.akimts.mvc.models.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
