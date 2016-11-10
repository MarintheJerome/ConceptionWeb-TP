package Servlet;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by Yhugo on 09/11/2016.
 */
@WebServlet(name = "Inscription",urlPatterns={"/inscription","/Inscription"})
public class Inscription extends javax.servlet.http.HttpServlet {

    public static final String VUE ="/WEB-INF/Inscription.jsp";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
