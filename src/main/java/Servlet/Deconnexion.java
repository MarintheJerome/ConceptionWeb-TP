package Servlet;

import Utils.HibernateUtil;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Yhugo on 11/11/2016.
 */
@WebServlet(name = "Deconnexion",urlPatterns={"/deconnexion","/Deconnexion"})
public class Deconnexion extends HttpServlet {

    public static final String RESULT ="/WEB-INF/Result.jsp";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("Login", null);
        request.getSession().setAttribute("message", "Vous avec été déconnecté ! Have fun day.");
        this.getServletContext().getRequestDispatcher(RESULT).forward( request, response );
    }
}
