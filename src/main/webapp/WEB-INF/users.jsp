<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Users</title>
    </head>
<body>
    <h1>Register!!!!</h1>

	<h1> ${ user } </h1>

	<c:forEach var="user" items="${ users }" >
		<h1>Id: ${ user.id }</h1>
		<h1>Name: ${ user.name }</h1>
		<h1>Email: ${ user.email }</h1>
	</c:forEach>

    <form:form method="POST" action="/users" modelAttribute="user" >
		<form:label path="name" >Name:</form:label>
		<form:errors path="name" ></form:errors>
		<form:input path="name" ></form:input>
		
		<form:label path="email" >Email:</form:label>
		<form:errors path="email" ></form:errors>
		<form:input path="email" ></form:input>	
		
		<input type="submit" value="Register" />	
    </form:form>
</body>
</html>