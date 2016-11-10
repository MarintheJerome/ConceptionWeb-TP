package Servlet;

import Model.Abonne;
import Model.Annuaire;
import Model.Entreprise;
import Model.Particulier;
import Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

import static Utils.HibernateUtil.session;

/**
 * Created by Yhugo on 09/11/2016.
 */
@WebServlet(name = "Inscription",urlPatterns={"/inscription","/Inscription"})
public class Inscription extends javax.servlet.http.HttpServlet {

    public static final String VUE ="/WEB-INF/Inscription.jsp";
    public static final String LOGIN = "login";
    public static final String MDP = "mdp";
    public static final String CMDP = "cmdp";
    public static final String RAISON = "raisonsociale";
    public static final String NOM = "nom";
    public static final String PRENOM = "prenom";
    public static final String TYPE = "type";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String login = request.getParameter(LOGIN);
        String motDePasse = request.getParameter(MDP);
        String confirmation = request.getParameter(CMDP);
        String raison = request.getParameter(RAISON);
        String nom = request.getParameter(NOM);
        String prenom = request.getParameter(PRENOM);

        Annuaire annuaire = new Annuaire("AnnuaireDefault");
        Session sessionHibernate = HibernateUtil.currentSession();
        Transaction tx = sessionHibernate.beginTransaction();

        sessionHibernate.saveOrUpdate(annuaire);
        tx.commit();

        tx = sessionHibernate.beginTransaction();

        if(request.getParameter(TYPE) != null &&  request.getParameter(TYPE).equals("Entreprise")){
            if(motDePasse.equals(confirmation)) sessionHibernate.saveOrUpdate(new Entreprise(login,motDePasse,annuaire,raison));
        }
        if(request.getParameter(TYPE) != null &&  request.getParameter(TYPE).equals("Particulier")){
            if(motDePasse.equals(confirmation))sessionHibernate.saveOrUpdate(new Particulier(login,motDePasse,annuaire,nom,prenom));
        }

        tx.commit();

        this.getServletContext().getRequestDispatcher("/index.jsp").forward( request, response );

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
