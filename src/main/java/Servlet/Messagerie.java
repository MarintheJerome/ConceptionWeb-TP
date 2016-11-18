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
import java.util.List;

/**
 * Created by Yhugo on 10/11/2016.
 */
@WebServlet(name = "Messagerie",urlPatterns={"/messagerie","/Messagerie"})
public class Messagerie extends HttpServlet {

    public static final String VUE ="/WEB-INF/Messagerie.jsp";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();
        Session sessionHibernate = HibernateUtil.currentSession();
        Transaction tx = sessionHibernate.beginTransaction();

        String messages = "";

        if(session.getAttribute("Login") == null || session.getAttribute("Login").equals("")){
            messages="Veuillez vous connecter";
        }else{
            String q = "from Message";
            List<Model.Message> listemessage = sessionHibernate.createQuery(q).list();
            System.out.println(session.getAttribute("Login"));
            for (Model.Message m : listemessage){
                messages+="<tr>";
                messages+="<td>"+m.getSender().getLogin()+"</td>";
                messages+="<td>"+m.getObjet()+"</td>";
                messages+="<td>"+m.getMessage()+"</td>";
                messages+="</tr>";
            }
        }
        tx.commit();
        request.getSession().setAttribute("messages", messages);
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
