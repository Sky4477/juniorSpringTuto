package jn.spring.tuto.Service.Imp;

import jakarta.transaction.Transactional;
import jn.spring.tuto.Model.Employe;
import jn.spring.tuto.Model.Librairie;
import jn.spring.tuto.Model.Livre;
import jn.spring.tuto.Model.utils.AppTutoException;
import jn.spring.tuto.Repository.LibrairieRepository;
import jn.spring.tuto.Service.Interface.LibrairieManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class LibrairieService implements LibrairieManager {

    private final LibrairieRepository repo;

    @Override
    public Librairie createLibrairie(Librairie librairie) {
        return repo.save(librairie);
    }

    @Override
    public Librairie updateLibrairie(String nom,Librairie librairie) {
        Librairie find= repo.findByNom(nom);
        if(find!=null){
            find.setNom(librairie.getNom());
            find.setAdresse(librairie.getAdresse());
            return repo.save(find);
        }
        return null;
    }

    @Override
    public Librairie getLibrairie(String nom) {
        return repo.findByNom(nom);
    }

    @Override
    public Librairie getLibrairiebyId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String deleteLibrairie(String nom) {
        Librairie find= repo.findByNom(nom);
        if(find!=null){
            repo.delete(find);
            return "deleted";
        }
        return "error to delete";
    }

    @Override
    public List<Librairie> getAllLibrairies() {
        return repo.findAll();
    }

    @Override
    public Librairie addLivreToLibrairie(String nom, Livre livre) {
        Librairie find= repo.findByNom(nom);
        if(find!=null){
            find.getLivres().add(livre);
            livre.setLibrairie(find);
            return repo.save(find);
        }
        throw  new AppTutoException("librairie not found");
    }

    @Override
    public Librairie removeLivreFromLibrairie(String nom, Livre livre) {
        Librairie find= repo.findByNom(nom);
        if(find!=null){
            find.getLivres().remove(livre);
            return repo.save(find);
        }
        throw  new AppTutoException("librairie not found");
    }

    @Override
    public Librairie addEmployeToLibrairie(String nom, Employe employe) {
        Librairie find= repo.findByNom(nom);
        if(find!=null){
            find.getEmployes().add(employe);
            employe.setLibrairie(find);
            return repo.save(find);
        }
        throw  new AppTutoException("librairie not found");
    }

    @Override
    public Librairie removeEmployeFromLibrairie(String nom, Employe employe) {
        Librairie find= repo.findByNom(nom);
        if(find!=null){
            find.getEmployes().remove(employe);
            return repo.save(find);
        }
        throw  new AppTutoException("librairie not found");
    }
}
