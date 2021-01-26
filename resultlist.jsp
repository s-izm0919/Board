<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>
<head>
	<title>掲示板(仮)</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script src="js/main.js"></script>
</head>
<body>
	
    <h1>あなたの書き込み</h1>
    あなたの名前： ${name}<br>
    あなたの書き込み：<br>
    ${content}
     <br>

	<h1>投稿一覧</h1>
	<table >
		<c:forEach var="data" items="${database}">
			<tr><td>${data.number}</td><td>${data.name}</td><td>${data.time}</td></tr>
			<tr><td>${data.content}</td></tr>
		</c:forEach>
    </table>
    
    <button type="button" onclick="location.href='http://localhost:8080/Board/input'">戻る</button>
	
</body>
</html>