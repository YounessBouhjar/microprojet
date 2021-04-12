<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<form action="ConfirmerConnexion" method="POST">
		  <label for="email">Email:</label>
		  		<input type="text" id="email" name="email"><br>
		  <label for="motdepasse">Password:</label>
		  		<input type="password" id="motdepsse" name="motdepasse">
		  <input type="submit" value="s'identifier">
	</form> 
</body>
</html>