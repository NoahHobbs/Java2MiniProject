<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Pets</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
<form method = "post" action = "navServlet">
	<table>
		<c:forEach items="${requestScope.allPets}" var="currentpet">
		<tr>
			<td><input type="radio" name="id" value="${currentpet.id}"></td>
			<td>${currentpet.petName}</td>
			<td>${currentpet.petBirthday}</td>
		</tr>
		</c:forEach>
	</table>
	<input type = "submit" value ="deleteP" name="doThisToItem">
	</form>
		<a href = "index.html">Home</a>
		<a href = "addServlet">Add Pets</a>
		<a href = "ownersServlet"> View all Owners</a>
</body>
</html>