package jn.spring.tuto.Service.Interface;

import jn.spring.tuto.Model.Employe;

import java.util.List;

public interface EmployManager {

    Employe createEmploy(Employe employ);
    Employe updateEmploy(Employe employ);
    void deleteEmploy(String nom);
    Employe getEmploy(String nom);
    List<Employe> getAllEmploy();
}
