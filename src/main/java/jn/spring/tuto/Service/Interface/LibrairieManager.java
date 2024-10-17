package jn.spring.tuto.Service.Interface;

import jn.spring.tuto.Model.Employe;
import jn.spring.tuto.Model.Librairie;
import jn.spring.tuto.Model.Livre;

import java.util.List;

public interface LibrairieManager {
    Librairie createLibrairie(Librairie librairie);

    Librairie updateLibrairie(String nom,Librairie librairie);

    Librairie getLibrairie(String nom);
    Librairie getLibrairiebyId(Long id);

    String deleteLibrairie(String nom);

    List<Librairie> getAllLibrairies();
    Librairie addLivreToLibrairie(String nom, Livre livre);
    Librairie removeLivreFromLibrairie(String nom, Livre livre);
    Librairie addEmployeToLibrairie(String nom, Employe employe);
    Librairie removeEmployeFromLibrairie(String nom, Employe employe);
}
