package jn.spring.tuto.Repository;

import jn.spring.tuto.Model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    Employe findByNom(String nom);
}