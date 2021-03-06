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

    @Column(name="message", columnDefinition="TEXT")
    private String message;

    @ManyToOne
    @JoinColumn(name="idAbonne")
    private Abonne sender;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
