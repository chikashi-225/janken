<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
<link rel="stylesheet" href="/dokotubu/css/dokotubu.css">
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
<c:out value="${loginUser.name }"/>さん、ログイン中
<a href="/dokotubu/Logout">ログアウト</a>
</p>
<p><a href="/dokotubu/Main">更新</a></p>
<form action="/dokotubu/Main" method="post">
<input type="text" name="text">
<input type="submit" value="つぶやく">
</form>
<c:if test="${errorMsg != null }">
	<p class="error">${errorMsg }</p>
</c:if>
<c:forEach var="mutter" items="${mutterList }">
	<p><c:out value="${mutter.userName }"/>:<c:out value="${mutter.text }"/></p>
	<p><a href="/dokotubu/DokotubuIndex?action=like">good</a><c:out value="${siteEV.like }"></c:out></p>
</c:forEach>
</body>
</html>