<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Date</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<form method="POST" action="/code">
    <label>Try Code: <input type="text" name="code"></label>
    <button>Login</button>
    <p><c:out value="${error}"></c:out></p>>
</form>
</body>
</html>