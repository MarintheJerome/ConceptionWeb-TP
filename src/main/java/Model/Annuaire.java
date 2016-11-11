package Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="annuaire")
public class Annuaire {

    @Id
    @Column(name="nomAnnuaire")
    private String nom;

    @OneToMany(mappedBy="annuaire")
    private Set<Abonne> abonnes = new HashSet<Abonne>();

    public Annuaire(){}
    public Annuaire(String nom){this.nom=nom;}

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public Set<Abonne> getAbonnes() {
        return abonnes;
    }

    public void setAbonnes(Set<Abonne> abonnes) {
        this.abonnes = abonnes;
    }
}
