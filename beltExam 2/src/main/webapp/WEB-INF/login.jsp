<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
.form {
	width: 48%;
	display: inline-block;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="form">
	<h1>Register</h1>
	<form:form action="/register" method="POST" modelAttribute="person">
	    <p>
	        <form:label path="name">Name: </form:label>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="email">Email: </form:label>
	        <form:input path="email"/>
	    </p>
	    <p>
	        <form:label path="password">Password: </form:label>
	        <form:input path="password"/>
	    </p>
	    <p>
	        <form:label path="passwordConfirmation">Password Conf: </form:label>
	        <form:input path="passwordConfirmation"/>
	    </p>
	    
	    <input type="submit" value="Register"/>
	</form:form>  
</div>
<div class="form">
	<h1>Login</h1>
	<form:form action="/login" method="POST" modelAttribute="person">
	
	    <p>
	        <form:label path="email">Email: </form:label>
	        <form:input path="email"/>
	    </p>
	    <p>
	        <form:label path="password">Password: </form:label>
	        <form:input path="password"/>
	    </p>

	    
	    <input type="submit" value="Login"/>
	</form:form>  
</div>
</body>
</html>