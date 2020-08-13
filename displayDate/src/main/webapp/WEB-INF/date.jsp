<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date Template</title>
<script type="text/javascript" src="js/date.js"></script>
</head>
<body>
<div style="display: inline-block">
	<h1 class="date">Date: <c:out value="${weekday}"></c:out>, the <c:out value="${day}"></c:out> of <c:out value="${month}"></c:out>, <c:out value="${year}"></c:out></h1>
</div>
</body>
</html>