<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
  width: 100%;
}
th {
  height: 40px;
}
tr {
  height: 30px;
}
table, th, td {
  border: 1px solid black;
  padding: 15px;
  text-align: left;
}
th {
	background-color: grey;
}
tr:nth-child(even) {background-color: #f2f2f2;}
.form-body {
	width: 80%;
	margin: auto;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Languages</h1>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${languages}" var="language">
        <tr>
            <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.version}"/></td>
            <td>
            	<form action="/languages/${language.id}" method="post">
    				<input type="hidden" name="_method" value="delete">
    				<input type="submit" value="Delete">
				</form> 
				<a href="languages/edit/${language.id}">edit</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<div class="form-body">
	<form:form action="/languages" method="post" modelAttribute="language">  
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