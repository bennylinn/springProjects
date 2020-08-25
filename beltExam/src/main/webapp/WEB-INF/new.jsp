<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Create a new Task</h1>
<form:form action="/tasks" method="POST" modelAttribute="task">
    <p>
        <form:label path="name">Task</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="priority">Priority</form:label>
        <form:select path="priority">
        	<option value="Low">Low</option>
        	<option value="Medium">Medium</option>
        	<option value="High">High</option>
        </form:select>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:select path="creator">
        	<c:forEach items="${persons}" var="person">
        		<option value="${person.id}"><c:out value="${person.name}"/></option>
        	</c:forEach>
        </form:select>
    </p>  
    <p>
    	<form:label path="assignee">Assignee</form:label>
        <form:select path="assignee">
        	<c:forEach items="${persons}" var="person">
        		<option value="${person.id}"><c:out value="${person.name}"/></option>
        	</c:forEach>
        </form:select>
    </p>
    <input type="submit" value="Submit"/>
</form:form>  
</body>
</html>