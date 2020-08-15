<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page isErrorPage="true" %>  --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
  width: 80%;
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
tr:nth-child(even) {background-color: #f2f2f2;}
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
            <td><a href="/languages"><c:out value="${language.name}"/></a></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.version}"/></td>
            <td><a>delete</a> <a>edit</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<div>
<form:form action="/languages" method="post" modelAttribute="language">
	<p>
		<form:label path="name">Name</form:label>
		<form:errors path="name"/>
		<form:input path="name"/>
	</p>
</form:form>
</div>
</body>
</html>