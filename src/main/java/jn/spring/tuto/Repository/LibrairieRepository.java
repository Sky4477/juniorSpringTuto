package jn.spring.tuto.Repository;

import jn.spring.tuto.Model.Librairie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrairieRepository extends JpaRepository<Librairie, Long> {
  Librairie findByNom(String nom);
}