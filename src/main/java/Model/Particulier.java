package Model;

import javax.persistence.*;

@Entity
public class Particulier extends Abonne{

    @Column(name="nomParticulier")
    private String nom;

    @Column(name="prenomParticulier")
    private String prenom;

    public Particulier(){}

    public Particulier(String l, String m, String n, String p) {
        super(l, m);
        this.nom = n;
        this.prenom = p;
    }

    public Particulier(String l, String m, Annuaire a, String n, String p) {
        super(l, m, a);
        this.nom = n;
        this.prenom = p;
    }

}
