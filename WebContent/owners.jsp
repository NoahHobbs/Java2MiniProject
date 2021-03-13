<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owners</title>
</head>
<body>
	<h1>These are all of the owners and their pets!</h1>
	<form method = "post" action = "ownernavigationServlet">
	<table>
	<c:forEach items="${requestScope.allOwners}" var="currentowners">
	<tr>
		<td><input type="radio" name="id" value="${currentowners.id}"></td>
		<td><h2>${currentowners.ownerName}</h2></td></tr>
		<tr><td></td><td colspan="3">
			<c:forEach items="${requestScope.oh.getPetsByOwnerId(currentowners.id)}" var="currentpets">
			<p>${currentpets.ownerName}</p>
			</c:forEach>
			</td>
		</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "delete" name="doThisList">
	<input type = "submit" value = "add" name = "doThisList">
	</form>
	<a href="addStudentsForListServlet">Create a new Owner</a>
	<a href="index.html">Add a new pet</a>
</body>
</html>