package jn.spring.tuto.Service.Imp;

import jakarta.transaction.Transactional;
import jn.spring.tuto.Model.Employe;
import jn.spring.tuto.Model.utils.AppTutoException;
import jn.spring.tuto.Repository.EmployeRepository;
import jn.spring.tuto.Service.Interface.EmployManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @AllArgsConstructor @Transactional
public class EmployeService implements EmployManager {
    private final EmployeRepository repo;
    @Override
    public Employe createEmploy(Employe employ) {
        return repo.save(employ);
    }

    @Override
    public Employe updateEmploy(Employe employ) {
        Employe find= repo.findByNom(employ.getNom());
        if(find!=null){
            find.setNom(employ.getNom());
            find.setPrenom(employ.getPrenom());
            find.setEmail(employ.getEmail());
            return repo.save(find);
        }
        throw new AppTutoException("error to update");
    }

    @Override
    public void deleteEmploy(String nom) {
        Employe find= repo.findByNom(nom);
        if(find!=null){
            repo.delete(find);
        }
    }

    @Override
    public Employe getEmploy(String nom) {
        return repo.findByNom(nom);
    }

    @Override
    public List<Employe> getAllEmploy() {
        return repo.findAll();
    }
}
