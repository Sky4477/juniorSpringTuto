package jn.spring.tuto.Service.Interface;
import jn.spring.tuto.Model.Livre;

import java.util.List;

public interface LivreManager {
    Livre CreateLire(Livre livre);
    Livre UpdateLire(String titre, Livre livre);
    Livre getLire(String titre);
    Livre getLireById(Long id);
    String deleteLire(String titre);
    List<Livre> getAllLire();
}
