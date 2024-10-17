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
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nom;
    private String prenom;
    private String email;

    @ManyToOne
    @JoinColumn(name = "librairie_id")
    @JsonBackReference
    private Librairie librairie;

    public Employe(String nom,String prenom,String email){
        this.email=email;
        this.nom=nom;
        this.prenom=prenom;
    }

}