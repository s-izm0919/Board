<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="ja">
<head>
<meta charset="SJIS">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>選択掲示板topページ</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="ここにサイト説明を入れます">
<meta name="keywords" content="キーワード１,キーワード２,キーワード３,キーワード４,キーワード５">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/fixmenu_pagetop.css">
<script type="text/javascript" src="js/openclose.js"></script>
<script type="text/javascript" src="js/fixmenu_pagetop.js"></script>
<script src="js/main.js"></script>
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
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
<style>
  header{
    height: 100%;
  }
</style>
<body>
<div id="container">
<div id="mainimg">メインイメージ</div>  
        


<header>

<h1 id="logo"><a href="postthread.jsp"><img src="images/logo1.png" alt="Sample Site"></a></h1>
<!--PC用（801px以上端末）メニュー-->
<nav id="menubar">
<ul>
<li id="menu1"><a href="addthread"><img src="images/menu_about1.png" alt="当サイトについて"></a></li>
<li id="menu2"><a href="#gallery"><img src="images/menu_gallery.png" alt="ギャラリー"></a></li>
<li id="menu3"><a href="#link"><img src="images/menu_link.png" alt="リンク"></a></li>
<li id="menu4"><a href="#"><img src="images/menu_instagram.png" alt="インスタグラム"></a></li>
</ul>
</nav>

</header>
<div class="contents bg1"><!--contentsブロック開始＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝-->

<section>
    
<h2>Read Me<span></span></h2>
	
</section>  


</div>
<!--/container-->

</body>
</html>
