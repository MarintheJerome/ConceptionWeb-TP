package Servlet;

import Model.Abonne;
import Model.Message;
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
@WebServlet(name = "Message",urlPatterns={"/message","/Message"})
public class Envoie extends HttpServlet {

    public static final String VUE ="/WEB-INF/Message.jsp";
    public static final String RESULT ="/WEB-INF/Result.jsp";
    public static final String OBJET = "objet";
    public static final String TEXT = "message";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String object = request.getParameter(OBJET);
        String text = request.getParameter(TEXT);

        HttpSession session = request.getSession();
        Session sessionHibernate = HibernateUtil.currentSession();
        Transaction tx = sessionHibernate.beginTransaction();

        StringBuilder message = new StringBuilder();

        if(session.getAttribute("Login") == null || session.getAttribute("Login").equals("")){
            message.append("Veuillez vous connecter.");
        }else{
            Abonne a = new Abonne();
            a.setLogin((String)session.getAttribute("Login"));
            String q = "from Abonne a where a.login =:login";
            Query query = sessionHibernate.createQuery(q);
            query.setParameter("login",a.getLogin());
            Abonne Result = (Abonne)query.uniqueResult();
            Model.Message m = new Model.Message(object, text);
            m.setSender(a);
            sessionHibernate.saveOrUpdate(m);
            message.append("Message Envoyé, merci d'utiliser notre service "+session.getAttribute("Login"));
        }

        tx.commit();
        request.getSession().setAttribute("message", message);
        this.getServletContext().getRequestDispatcher(RESULT).forward( request, response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
