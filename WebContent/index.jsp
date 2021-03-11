<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index page</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<h1> Welcome to our Java 2 mini project</h1>
	<form action="addPetServlet" method="post">
	Name: <input type = "text" name = "name">
	Birthday: <input type = "text" name = "birthday">
	<input type="submit" value="Add Item">	
	</form> <br />
	<a href = "/viewAllPetsServlet"> View all Pets</a>
</body>
</html>