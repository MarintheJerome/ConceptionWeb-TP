package Model;

import javax.persistence.*;

@Entity
@Table(name="entreprise")
public class Entreprise extends Abonne{

    @Column(name="raisonSocial")
    private String raisonSocial;

    public Entreprise(){}

    public Entreprise(String l, String m, String s) {
        super(l, m);
        this.raisonSocial=s;
    }

    public Entreprise(String l, String m, Annuaire a, String s) {
        super(l, m, a);
        this.raisonSocial=s;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }
}
