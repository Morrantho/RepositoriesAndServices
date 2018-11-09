<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> ${ user.email } </title>
</head>
<body>
	<h1>Id: ${ user.id }</h1>
	<h1>Name: ${ user.name }</h1>
	<h1>Email: ${ user.email }</h1>
	
    <form:form method="POST" action="/users/update" modelAttribute="user" >
		<form:input type="hidden" path="id" ></form:input>
    	
		<form:label path="name" >Name:</form:label>
		<form:errors path="name" ></form:errors>
		<form:input path="name" ></form:input>
		
		<form:label path="email" >Email:</form:label>
		<form:errors path="email" ></form:errors>
		<form:input path="email" ></form:input>	
		
		<input type="submit" value="Update" />	
    </form:form>
</body>
</html>