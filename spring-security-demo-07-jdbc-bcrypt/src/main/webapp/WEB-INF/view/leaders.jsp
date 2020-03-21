<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leaders home page</title>
</head>
<body>
	<h2>Leaders home page</h2>
	<hr>
	Welcome on the Leaders Home Page!
	
	<hr>
	
	<p>
		Restricted access for Managers
	</p>
	
	<hr/>
	
	<a href="${pageContext.request.contextPath}/employees">Main page</a>
	
</body>
</html>