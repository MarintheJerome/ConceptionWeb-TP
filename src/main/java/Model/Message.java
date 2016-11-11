package Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="message")
public class Message {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    @Column(name="idMessage")
    private int id;

    @Column(name="objet")
    private String objet;

    @Column(name="message")
    private String message;

    @ManyToOne
    @JoinColumn(name="idAbonne")
    private Abonne sender;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="AbonneMessage", joinColumns={@JoinColumn(name="idMessage")}, inverseJoinColumns={@JoinColumn(name="loginAbonne")})
    private Set<Abonne> receivers = new HashSet<Abonne>();

    public Message(){}
    public Message(String o, String m){this.objet=o; this.message=m;}

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Abonne getSender() {
        return sender;
    }

    public void setSender(Abonne sender) {
        this.sender = sender;
    }

    public Set<Abonne> getReceivers() {
        return receivers;
    }

    public void setReceivers(Set<Abonne> receivers) {
        this.receivers = receivers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
