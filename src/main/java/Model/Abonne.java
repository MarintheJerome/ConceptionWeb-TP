package Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="abonne")
@Inheritance(strategy = InheritanceType.JOINED)
public class Abonne {

    @Id
    @Column(name = "loginAbonne")
    private String login;

    @Column(name = "mdpAbonne")
    private String mdp;

    @ManyToOne
    @JoinColumn(name = "idAnnuaire")
    private Annuaire annuaire;

    @OneToMany(mappedBy = "sender")
    private Set<Message> messagesEmitted = new HashSet<Message>();

    public Abonne() {
    }

    public Abonne(String l, String m) {
        this.login = l;
        this.mdp = m;
    }

    public Abonne(String l, String m, Annuaire a) {
        this.login = l;
        this.mdp = m;
        this.annuaire = a;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Annuaire getAnnuaire() {
        return annuaire;
    }

    public void setAnnuaire(Annuaire annuaire) {
        this.annuaire = annuaire;
    }

    public Set<Message> getMessagesEmitted() {
        return messagesEmitted;
    }

    public void setMessagesEmitted(Set<Message> messagesEmitted) {
        this.messagesEmitted = messagesEmitted;
    }

}
