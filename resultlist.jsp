<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>
<head>
	<title>�f����(��)</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script src="js/main.js"></script>
</head>
<body>
	
    <h1>���Ȃ��̏�������</h1>
    ���Ȃ��̖��O�F ${name}<br>
    ���Ȃ��̏������݁F<br>
    ${content}
     <br>

	<h1>���e�ꗗ</h1>
	<table >
		<c:forEach var="data" items="${database}">
			<tr><td>${data.number}</td><td>${data.name}</td><td>${data.time}</td></tr>
			<tr><td>${data.content}</td></tr>
		</c:forEach>
    </table>
    
    <button type="button" onclick="location.href='http://localhost:8080/Board/input'">�߂�</button>
	
</body>
</html>