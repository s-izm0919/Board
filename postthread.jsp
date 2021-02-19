<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja">
<head>
<meta charset="SJIS">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>投稿登録</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="ここにサイト説明を入れます">
<meta name="keywords" content="キーワード1,キーワード2,キーワード3,キーワード4,キーワード5">
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
        background-color:rgb(216, 209, 178);
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
<script type="text/javascript"> 
	<!-- 
		
		function check(){
		
			var flag = 0;
		
		
			// 設定開始（必須にする項目を設定してください）
		
			if(document.form1.name.value == ""){ // 「お名前」の入力をチェック
		
				flag = 1;
		
			}
			else if(document.form1.title.value == ""){ // 「title」の入力をチェック
		
				flag = 1;
		
			}
			else if(document.form1.content.value == ""){ // 「コメント」の入力をチェック
		
				flag = 1;
			}
			else if(document.form1.question.value == ""){ // 「質問」の入力をチェック
		
				flag = 1;
			}
			else if(document.form1.choice1.value == ""){ // 「選択1」の入力をチェック
		
				flag = 1;
			}
			else if(document.form1.choice2.value == ""){ // 「選択2」の入力をチェック
		
				flag = 1;

			}
		
			// 設定終了
			if(flag){
	
			window.alert('必須項目に未入力がありました'); // 入力漏れがあれば警告ダイアログを表示
			return false; // 送信を中止
	
	}
			else{
	
			return true; // 送信を実行
	
	}
	
	}
	
	// -->
	</script>        
	
</head>



<body>

<header >
		
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

<div class="contents bg3"><!--contentsブロック開始＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝-->

<section>

<h2>Read Me<span></span></h2>

<h3>投稿登録</h3>
	<form method='post' action='addthread' name="form1" onSubmit="return check()">
	ユーザー名:<br>
	<input type='text' name='name' placeholder="NONAME"><br>
	title:<br>
	<input type='text' name='title' placeholder="titleを記入してください"><br>
	投稿文：<br>
	<textarea name='content' placeholder="こちらに投稿文を記入" cols="50" rows="5"></textarea><br>
	質問：<br>
	<input type='text' name='question'placeholder="質問を記入してください"><br>
	選択1：  <input type='text'name='choice1'> <br>      選択2：<input type='text' name='choice2'><br>
	<input type='submit' value='登録'>
    </form>
	
</section>

</body>

</html>