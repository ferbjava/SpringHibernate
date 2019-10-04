<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>

</head>

<body>

	<form:form action="processForm" modelAttribute="student">
		First name : <form:input path="firstName"/>
		
		<br><br>
		
		Last name : <form:input path="lastName"/>
		
		<br><br>
		
		Country:
		<form:select path="country">
		
			<form:options items="${countryOptions}"></form:options>
		
		</form:select>
		
		<br><br>
		
		Favorite Language:
		<br>
		Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		C# <form:radiobutton path="favoriteLanguage" value="C#"/>
		Pascal <form:radiobutton path="favoriteLanguage" value="Pascal"/>
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
		
		<br>
		
		Known OSs:
		
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
		Windows <form:checkbox path="operatingSystems" value="Windows"/>
		<br>
		
		<input type="submit" value="Submit">
	</form:form>

</body>

</html>