<%@ page pageEncoding="Windows-31J"
	 contentType="text/html;charset=Windows-31J" %>
<html>
<head>
	<title>掲示板(仮)</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script src="js/main.js"></script>
</head>
<body>
	<h1>新規書き込み</h1>
	<form method='post' action='adduser'>
	ユーザー名:<br>
	<input type='text' name='name' placeholder="NONAME"><br>
	投稿文：<br>
	<textarea name='content' placeholder="こちらに投稿文を記入" cols="50" rows="5"></textarea><br><br>
	<input type='submit' value='登録'>
	</form>

	<h1>掲示板閲覧</h1>
	<p>掲示板をただ見るだけ</p>
	<form method='get' action='adduser'>
	<input type='submit' value="閲覧">
</body>
</html>
