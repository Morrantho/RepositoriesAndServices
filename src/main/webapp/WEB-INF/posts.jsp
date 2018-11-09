<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form:form method="POST" action="/posts" modelAttribute="post" >
		<form:label path="title" >Title:</form:label>
		<form:errors path="title" ></form:errors>
		<form:input path="title" ></form:input>
		
		<form:label path="description" >Description:</form:label>
		<form:errors path="description" ></form:errors>
		<form:input path="description" ></form:input>	
		
		<input type="submit" value="Create Post" />	
    </form:form>

	<c:forEach var="post" items="${ posts }" >
		<h1> ${ post.title } </h1>	
		<h1> ${ post.description } </h1>				
	</c:forEach>
</body>
</html>