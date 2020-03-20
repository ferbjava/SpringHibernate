<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forbidden!</title>
</head>
<body>
	<h2>Access forbidden!</h2>
	<hr>
	You don't have rights to get this page!
	
	<hr>
	
	<p>
		<a href="${pageContext.request.contextPath}/employees">Go back to main Main Page</a>
	</p>
	
</body>
</html>