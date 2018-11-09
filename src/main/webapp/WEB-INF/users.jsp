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

	<hr>

	<h1>Register</h1>

    <form:form method="POST" action="/users" modelAttribute="user" >
    	<c:if test="${ exists != null}">
    		<p>${ exists }</p>
    	</c:if>
    	<c:if test="${ regError != null}">
    		<p>${ regError }</p>
    	</c:if>    
    	
		<p><form:label path="email" >Email:</form:label></p>
		<p><form:errors path="email" ></form:errors></p>
		<p><form:input path="email" ></form:input>	</p>				
		
		<p><form:label path="name" >Name:</form:label></p>
		<p><form:errors path="name" ></form:errors></p>
		<p><form:input path="name" ></form:input></p>
		
		<p><form:label path="password" >Password:</form:label></p>
		<p><form:errors path="password" ></form:errors></p>
		<p><form:input path="password" ></form:input></p>	
		
		<p><form:label path="confirm" >Password Confirmation:</form:label></p>
		<p><form:errors path="confirm" ></form:errors></p>
		<p><form:input path="confirm" ></form:input></p>
		
		<input type="submit" value="Update" />	
    </form:form>
    
	<h1>Login</h1>
    
    <form action="/users/login" method="POST">
		<input name="email" placeholder="Email" />
		<input name="password" placeholder="Password" />
    	<input type="submit" value="Login" />
    </form>
</body>
</html>