package Servlet;

import Model.Abonne;
import Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Yhugo on 10/11/2016.
 */
@WebServlet(name = "Connexion",urlPatterns={"/connexion","/Connexion"})
public class Connexion extends HttpServlet {

    public static final String VUE ="/WEB-INF/Connexion.jsp";
    public static final String RESULT ="/WEB-INF/Result.jsp";
    public static final String LOGIN = "login";
    public static final String MDP = "mdp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter(LOGIN);
        String motDePasse = request.getParameter(MDP);

        HttpSession session = request.getSession();
        Session sessionHibernate = HibernateUtil.currentSession();
        Transaction tx = sessionHibernate.beginTransaction();

        StringBuilder message = new StringBuilder();

        Abonne a = null;

        if(login != null && motDePasse !=null){
            a = sessionHibernate.get(Abonne.class, login);
            if(a ==null){
                message.append("Fail");
            }
            if(a != null){
                session.setAttribute("Login", login);
                message.append("Success ! Bienvenue "+a.getLogin());
            }

        }else{
            message.append("Il manque une valeur");
        }

        tx.commit();
        request.getSession().setAttribute("message", message);
        this.getServletContext().getRequestDispatcher(RESULT).forward( request, response );

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
