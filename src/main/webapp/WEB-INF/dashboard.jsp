<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
	<h1> Welcome, ${ userData.name } </h1>
	
	<c:forEach var="post" items="${ posts }" >
		<h1> ${ post.title } </h1>	
		<h1> ${ post.description } </h1>				
	</c:forEach>	
</body>
</html>