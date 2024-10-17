package jn.spring.tuto.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "titre", nullable = false,updatable = false,unique = true)
    private String titre;
    private String auteur;
    @Column(name = "genre", nullable = false,updatable = false)
    private String genre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "librairie_id")
    @JsonBackReference
    private Librairie librairie;


    public Livre(String titre, String auteur, String genre) {
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;

    }

}