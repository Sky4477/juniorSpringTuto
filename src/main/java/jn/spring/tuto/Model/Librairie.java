package jn.spring.tuto.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Librairie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String nom;
    private String adresse;

    @OneToMany(mappedBy = "librairie", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employe> employes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "librairie", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Livre> livres = new LinkedHashSet<>();

    public Librairie(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }
}
