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
<h1>Welcome</h1>
<table>
    <thead>
        <tr>
            <th>Task</th>
            <th>Creator</th>
            <th>Assignee</th>
            <th>Priority</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${tasks}" var="task">
        <tr>
            <td><a href="/tasks/${task.id}"><c:out value="${task.name}"/></a></td>
            <td><c:out value="${task.creator.name}"/></td>
            <td><c:out value="${task.assignee.name}"/></td>
            <td><c:out value="${task.priority}"/></td>
        </tr>
        </c:forEach> 
    </tbody>
</table>
<a href="/tasks/new">Create Task</button>
</body>
</html>