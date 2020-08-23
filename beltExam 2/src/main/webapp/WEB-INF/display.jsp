<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Task: <c:out value="${task.name}"/></h1>
<li>Creator: <c:out value="${task.creator.name}"/></li>
<li>Assignee: <c:out value="${task.assignee.name}"/></li>
<li>Priority: <c:out value="${task.priority}"/></li>

<a href="${task.id}/edit">Edit</a>
<form action="/tasks/${task.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form> 
<form action="/tasks/${task.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Completed">
</form> 
</body>
</html>