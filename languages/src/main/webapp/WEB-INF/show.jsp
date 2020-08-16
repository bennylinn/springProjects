<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><c:out value="${language.name}"></c:out> <c:out value="${language.version}"></c:out></h1>
<h3>Created by <c:out value="${language.creator}"></c:out>.</h3>
<a href="/languages/edit/${language.id}">Edit</a>
<a href="/languages">delete</a>
</body>
</html>