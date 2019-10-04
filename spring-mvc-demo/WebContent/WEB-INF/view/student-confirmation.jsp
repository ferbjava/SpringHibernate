<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

<head>
	<title>Student confirmation</title>
</head>

<body>

	The student is confirmed: ${student.firstName} ${student.lastName}
	
	<br><br>
	Country: ${student.country}
	
	<br><br>
	Student Favorite Language: ${student.favoriteLanguage}
	
	<br><br>
	Known Operating Systems
	<br>
	<c:forEach var="temp" items="${student.operatingSystems}">
		
		<li> ${temp} </li>
		
	</c:forEach>

</body>

</html>