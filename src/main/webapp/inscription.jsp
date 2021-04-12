<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<form action="ConfirmerInscription" method="POST">
  <label for="nom">Nom:</label>
  		<input type="text" id="nom" name="nom" ><br>
 
  <label for="prenom">Prenom:</label>
  		<input type="text" id="prenom" name="prenom"><br>

  <label for="adresse">Adresse:</label>
  		<input type="text" id="adresse" name="adresse" placeholder="adresse"><br>
  		<input type="text" id="codepostal" name="codepostal" placeholder="codepostal">
  		<input type="text" id="ville" name="ville" placeholder="ville"><br>
  
  <label for="tel">Tel:</label>
  		<input type="text" id="tel" name="tel"><br>
  
   <label for="email">Email:</label>
  		<input type="text" id="email" name="email"><br>
  
  <label for="motdepasse">Password:</label>
  		<input type="password" id="motdepasse" name="motdepasse"><br>
  
  <input type="submit" value="S'inscrire">
</form> 
</body>
</html>