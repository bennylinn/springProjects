<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
.form-body {
  width: 80%;
  margin: auto;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
<a href="/languages">DashBoard</a>
<form action="/languages/${language.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form> 
</header>
<div class="form-body">
	<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
		<input type="hidden" name="_method" value="put">
		<p>
	        <form:label path="name">Name: </form:label>
			<form:input path="name"/>
	    </p>
	    <p style="color: red; font-size: 12px;"><form:errors path="name"/></p>
	    <p>
	        <form:label path="creator">Creator: </form:label>
			<form:input path="creator"/>
	    </p>
	    <p style="color: red; font-size: 12px;"><form:errors path="creator"/></p>
	    <p>
	        <form:label path="version">Version: </form:label>
			<form:input path="version"/>
	    </p>
	    <p style="color: red; font-size: 12px;"><form:errors path="version"/></p>
	    <input type="submit" value="Submit"/>
	</form:form>
</div>
</body>
</html>