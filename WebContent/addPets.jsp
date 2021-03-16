<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Pets</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
<h1>Add a Pet!</h1>
<form action="addPetServlet" method="post">
	Name: <input type = "text" name = "name">
	Birthday: <input type = "text" name = "month" placeholder="mm" size="4">
	<input type="text" name ="day" placeholder="dd" size="4">, 
	<input type="text" name ="year" placeholder="yyyy" size="4">
	 <label for="owner">Choose an Owner:</label>
	<select name="owner" id="owner">
	<c:forEach items="${requestScope.allOwners}" var="currentowners">
	  <option value="${currentowners.id}">${currentowners.ownerName}</option>
	</c:forEach>
	</select>
	<input type="submit" value="Add Item">	
	</form> <br />
	<a href="index.html">Home</a>
</body>
</html>