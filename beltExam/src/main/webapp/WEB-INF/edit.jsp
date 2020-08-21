<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Edit: <c:out value="${task.name}"/></h1>
<form:form action="/tasks/${task.id}" method="POST" modelAttribute="task">
	<input type="hidden" name="_method" value="PUT">
    <p>
        <form:label path="name">Task</form:label>
        <form:input path="name"/>
    </p>
    <p style="color: red; font-size: 12px;"><c:out value="${error}"></c:out></p>
    <p>
        <form:label path="priority">Priority</form:label>
        <form:select path="priority">
        	<option value="Low">Low</option>
        	<option value="Medium">Medium</option>
        	<option value="High">High</option>
        </form:select>
    </p>
    <p>
        <form:label path="c_id">Creator</form:label>
        <form:select path="c_id">
        	<c:forEach items="${persons}" var="person">
        		<option value="${person.id}"><c:out value="${person.name}"/></option>
        	</c:forEach>
        </form:select>
    </p>  
    <p>
    	<form:label path="a_id">Assignee</form:label>
        <form:select path="a_id">
        	<c:forEach items="${persons}" var="person">
        		<option value="${person.id}"><c:out value="${person.name}"/></option>
        	</c:forEach>
        </form:select>
    </p>
    <input type="submit" value="Submit"/>
</form:form>  
</body>
</html>