<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold</title>
</head>
<body>
<h1>Ninja Gold</h1>
<h3>Your Gold: </h3>

<div>
    <div class="square" style="display: inline-block; margin: auto; border: 2px solid green;">
        <h4>Farm</h4>
        <p>(earns 10-20 gold)</p>
        <form action="/farm" method="POST">
            <button type="submit">Find Gold!</button>
        </form>
    </div>
    <div class="square" style="display: inline-block; margin: auto; border: 2px solid green;">
        <h4>Cave</h4>
        <p>(earns 5-10 gold)</p>
        <form action="/cave" method="POST">
            <button type="submit">Find Gold!</button>
        </form>
    </div>
    <div class="square" style="display: inline-block; margin: auto; border: 2px solid green;">
        <h4>House</h4>
        <p>(earns 2-5 gold)</p>
        <form action="/house" method="POST">
            <button type="submit">Find Gold!</button>
        </form>
    </div>
    <div class="square" style="display: inline-block; margin: auto; border: 2px solid green;">
        <h4>Casino</h4>
        <p>(earns/takes 0-50 gold)</p>
        <form action="/casino" method="POST">
            <button type="submit">Find Gold!</button>
        </form>
    </div>
</div>

<p>Activities: </p>
<div style="width: 480px; height: 100px; border: 2px solid green; margin: 10px;">
	<p style="color: red"><c:out value="${gain}"></c:out></p>
    <p>You have <c:out value="${gold}"></c:out> gold!</p>
</div>
</body>
</html>