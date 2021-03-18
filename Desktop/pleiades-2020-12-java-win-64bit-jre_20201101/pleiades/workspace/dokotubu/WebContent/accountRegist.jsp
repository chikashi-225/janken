<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント登録</title>
<link rel="stylesheet" url="/dokotubu/css/dokotubu.css">
</head>
<body>
<h1>アカウント登録</h1>
	<form action="/dokotubu/Result" method="post">
		<p>ユーザーID:<input type="text" name="name"></p>
		<p>パスワード:<input type="password" name="pass"></p>
		<p class="size">※パスワードは半角数字5桁</p>
		<input type="submit" value="登録">
	</form>
</body>
</html>