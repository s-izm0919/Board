<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja">
<head>
<meta charset="SJIS">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>投稿文一覧</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="ここにサイト説明を入れます">
<meta name="keywords" content="キーワード１,キーワード２,キーワード３,キーワード４,キーワード５">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/fixmenu_pagetop.css">
<script type="text/javascript" src="js/openclose.js"></script>
<script type="text/javascript" src="js/fixmenu_pagetop.js"></script>
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
	
<style>
	header{
		height:0.1%;
	}
    input{
        background-color:blanchedalmond;
    }
    textarea{
        background-color:rgb(216, 209, 178);
    }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(function(){
$('a[href^="#"]').click(function() {
var speed = 800;
var href= $(this).attr("href");
var target = $(href == "#" || href == "" ? 'html' : href);
var position = target.offset().top;
$('body,html').animate({scrollTop:position}, speed, 'swing');
return false;
});
});
</script>
</head>

<body>
    

<header >
		
<h1 id="logo"><a href="postthread.jsp"><img src="images/logo1.png" alt="Sample Site"></a></h1>
<!--PC用（801px以上端末）メニュー-->
<nav id="menubar">
<ul>
<li id="menu1"><a href="addthread"><img src="images/menu_about1.png" alt="当サイトについて"></a></li>
<li id="menu2"><a href="返答文登録.html"><img src="images/menu_gallery.png" alt="ギャラリー"></a></li>
<li id="menu3"><a href="#link"><img src="images/menu_link.png" alt="リンク"></a></li>
<li id="menu4"><a href="#"><img src="images/menu_instagram.png" alt="インスタグラム"></a></li>
</ul>
</nav>
</header>

<div class="contents bg4"><!--contentsブロック開始＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝-->

<section>

<h2>Read Me</h2>
<h3>投稿文一覧</h3>
    <form name="sort">
	<select name="sort1" onChange="if(document.sort.sort1.value){location.href=document.sort.sort1.value;}">
		<option >◆並べ替えはこちら◆</option>
	 	<option value="addthread?sort=1">投稿日の新しい順</option>
		<option value="addthread?sort=2">投稿日の古い順</option>
		<option value="addthread?sort=3">投票の多い順</option>
	</select> 
	</form>

	<h1>投稿一覧</h1>
	<table border="1">
		<c:forEach var="data" items="${data}">
			<tr><td>${data.number}</td><td>${data.name}</td><td>${data.time}</td></tr>
			<tr><td><a href="resthread?id=${data.id}">${data.title}</a></td><td>${data.content}</td></tr>
			<tr><td>${data.question}</td><td>${data.choice1}</td><td>${data.choice2}</td></tr>
		</c:forEach>
    </table>

	<table>
	<tr>
		<c:forEach var="page" items="${page}">
			<td>
			<a href="addthread?page=${page}&sort=${sort}">${page}</a>
			</td>
		</c:forEach>
	<tr>
	<table>


</div>
<!--/container-->

</body>
</html>
