<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owners</title>
<link href="style.css" rel="stylesheet">

</head>
<body>
	<h1>These are all of the owners and their pets!</h1>
	<form method = "post" action = "navServlet">
	<table>
	<c:forEach items="${requestScope.allOwners}" var="currentowners">
	<tr>
		<td><input type="radio" name="id" value="${currentowners.id}"></td>
		<td><h2>${currentowners.ownerName}</h2></td></tr>
		<tr><td></td><td colspan="3">
			<c:forEach items="${requestScope.oh.getPetsByOwnerId(currentowners.id)}" var="currentpets">
			<p>${currentpets.petName}</p>
			</c:forEach>
			</td>
		</tr>
	</c:forEach>
	
	</table>
	<input type = "submit" value = "deleteO" name="doThisToItem">
	<p>Name: <input type ="text" name = "nameO">
	<input type = "submit" value = "addO" name = "doThisToItem">
	<input type = "submit" value = "change name" name = "doThisToItem">
	</p></form>
	<a href="index.html">Home</a>
	<a href = "addServlet">Add new Pet</a>
	<a href = "viewAllPetsServlet"> View all Pets</a>
</body>
</html>