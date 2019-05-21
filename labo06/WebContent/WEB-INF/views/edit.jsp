<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<input type="button" onclick="location.href='${pageContext.request.contextPath}/'" value="Regresar" />
	<form:form action="${pageContext.request.contextPath}/edit" method="POST" modelAttribute="student">
		<form:input type="hidden" name="cStudent" path="cCLiente"/>
		<label>Ingrese un nombre: </label>
		<form:input type="text" name="name" path="sName"/><br>
		<label>Ingrese un apellido: </label>
		<form:input type="text" name="lname" path="lName"/><br>
		<label>Ingrese edad: </label>
		<form:input type="number" name="age" path="sAge"/><br>
		<label>Estado del estudiante: </label><br>
		<form:radiobutton name="status" path="bActivo" value="true"/><label>Activo</label><br>
		<form:radiobutton name="status" path="bActivo" value="false"/><label>Inactivo</label><br>
		<input type="submit" value="Editar">
	</form:form>
</body>
</html>