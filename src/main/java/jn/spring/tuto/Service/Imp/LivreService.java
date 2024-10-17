package jn.spring.tuto.Service.Imp;

import jakarta.transaction.Transactional;
import jn.spring.tuto.Model.Livre;
import jn.spring.tuto.Model.utils.AppTutoException;
import jn.spring.tuto.Repository.LivreRepository;
import jn.spring.tuto.Service.Interface.LivreManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class LivreService  implements LivreManager {
    private  final LivreRepository repo;

    @Override
    public Livre CreateLire(Livre livre) {
        return repo.save(livre);
    }

    @Override
    public Livre UpdateLire(String titre, Livre livre) {
        Livre find = repo.findByTitre(titre);
        if (find != null) {
            find.setTitre(livre.getTitre());
            find.setAuteur(livre.getAuteur());
            return repo.save(find);
        }
        throw new AppTutoException("Livre not found");}

    @Override
    public Livre getLire(String titre) {
        return repo.findByTitre(titre);
    }

    @Override
    public Livre getLireById(Long id) {
        return repo.getById(id);
    }

    @Override
    public String deleteLire(String titre) {
        Livre find = repo.findByTitre(titre);
        if (find != null) {
            repo.delete(find);
            return "deleted";
        }
        return "Livre not found";
    }

    @Override
    public List<Livre> getAllLire() {
        return repo.findAll();
    }
}
