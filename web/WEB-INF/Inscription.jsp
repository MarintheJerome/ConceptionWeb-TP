<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription</title>
</head>
<body>
<form method="POST">
    <input type="radio" name="type" value="Entreprise"> Entreprise<br>
    <input type="radio" name="type" value="Particulier"> Particuliers<br>
    <p>Login : <input type="text" id="login" name="login"></p>
    <p>MDP : <input type="password" id="mdp" name="mdp"></p>
    <p>Confirmer MDP : <input type="password" id="cmdp" name="cmdp"></p>
    <p> Si Entreprise :</p>
    <p>Raison Sociale  : <input type="text" id="raisonsociale" name="raisonsociale"></p>
    <p> Si Particulier :</p>
    <p>Nom : <input type="text" id="nom" name="nom"></p>
    <p>Prenom : <input type="text" id="prenom" name="prenom"></p>
    <p class="submit"><input type="submit" name="submit" id="submit" value="Inscription"></p>
    <label for="submit"></label>
</form>
<p><a href="/">Retour</a></p>
</body>
</html>