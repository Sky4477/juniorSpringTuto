package jn.spring.tuto.Repository;

import jn.spring.tuto.Model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, Long> {
    Livre findByTitre(String titre);
}
