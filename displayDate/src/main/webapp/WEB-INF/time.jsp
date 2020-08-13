<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Time</title>
<script type="text/javascript" src="js/time.js"></script>
</head>
<body>
<div style="display: inline-block">
	<h1 class="time">Time: <c:out value="${hour}"></c:out>:<c:out value="${minute}"></c:out> </h1>
</div>
</body>
</html>