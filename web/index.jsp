
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Application Web</title>
  </head>
  <p>
    <p></p><h2>Menu : </h2></p>
    <% if (request.getSession().getAttribute("Login") == null) { %>
   <p><a href="/connexion">Connexion </a></p>
    <% } else { %>
    <p><a href="/deconnexion">Déconnexion </a></p>
    <% } %>
    <p><a href="/inscription">Inscription</a></p>
    <p><a href="/message">Publier</a></p>
    <p><a href="/messagerie">Messages</a></p>
   <!-- <p><a href="/abonnement">Abonnement</a></p>-->
  </body>
</html>
