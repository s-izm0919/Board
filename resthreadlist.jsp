<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ja">
<head>
<meta charset="SJIS">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>投稿に返答一覧</title>
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

<script type="text/javascript"> 
	function lengthcheck(){
		
		var flag = 0;
		
		if(document.form1.rename.value.length > 5){ // 名前の文字数のチェック
		
			flag = 1;

            window.alert("名前は5文字以内で入力してください");
		
		}
		else if(document.form1.recontent.value.length > 500){ // 返答内容の文字数のチェック
		
			flag = 1;

            window.alert("返答内容は5文字以内で入力してください");
		}
		
		// 設定終了
		if(flag){

		return false; // 送信を中止
	
		}else{

         getRandom();
			
        return true; // 送信を実行

		}
	
	}

</script>

<script type="text/javascript">
    function getRandom(){
        let num = Math.floor(Math.random()*10000)+1;
        document.getElementById('formnumber').value = num;
    }
</script>
</head>



<body>

<header >
<h1 id="logo"><a href="postthread"><img src="images/logo1.png" alt="投稿画面"></a></h1>
<!--PC用（801px以上端末）メニュー-->
<nav id="menubar">
<ul>
<li id="menu1"><a href="addthread"><img src="images/menu_about1.png" alt="閲覧画面"></a></li>
<li id="menu2"><a href="index"><img src="images/menu_about.png" alt="トップに戻る"></a></li>
<!--
<li id="menu3"><a href="#link"><img src="images/menu_link.png" alt="リンク"></a></li>
<li id="menu4"><a href="#"><img src="images/menu_instagram.png" alt="インスタグラム"></a></li>
-->
    
</ul>
</nav>
</header>
        
<div class="contents bg2">
 <section>
<h2>Thread Response</h2>     

<h3>投稿されたスレッド</h3>
   <div class="Res_thread">
			<div class="th_title"><c:out value="${data.title}"/></div>
			<c:out value="${data.number}"/>&emsp;<c:out value="${data.name}"/>&emsp;<c:out value="${data.time}"/><br>
			<div class="th_content">
			<c:out value="${data.content}" escapeXml="false"/>
			</div>
			投稿者の質問：<c:out value="${data.question}"/><br>
			選択１：<c:out value="${data.choice1}"/>&emsp;&emsp;選択２：<c:out value="${data.choice2}"/><br>
	</div>
<h3>現在の集計結果</h3>
    投稿された質問：${data.question}<br>
	${data.choice1}：${agreement}<br>
    ${data.choice2}：${disagreement}<br>
	<div style="width: 300px;">
    <canvas id="chart" width="150" height="150"></canvas>
    </div>
    <br>

	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js" integrity="sha256-R4pqcOYV8lt7snxMQO/HSbVCFRPMdrhAFMH+vr9giYI=" crossorigin="anonymous"></script>
	<script>
        var ctx = $('#chart');
        var mychart = new Chart(ctx, {
            type: 'pie',
            data: {
                labels: [
                    '${data.choice1}',
                    '${data.choice2}',
                ],
                datasets: [{
                    label: 'サンプルグラフ',
                    data: [
                    	${agreement},
                        ${disagreement},
                    ],
                    backgroundColor: [
                        'rgba(241, 107, 141, 1)',
                        'rgba( 31, 167, 165, 1)',
                        'rgba(249, 199,  83, 1)',
                        'rgba(176, 110,  30, 1)',
                        'rgba(124,  91, 164, 1)'
                    ]
                }]
            },
            options: {
                legend: {
                    position: 'bottom',
                },
                scales: {
                    yAxes: [{
                        ticks: {
                            display: false,
                            beginAtZero: true,
                        },
                        gridLines: {
                            display: false
                        }
                    }]
                }
            }
        });
    </script>

    <h3>スレッドへの返信を投稿する</h3>
	<form method='post' action='resthread' name="form1" onSubmit="return lengthcheck()">

    <input id='formnumber' type='hidden' name='number' value="">
    
    <input type='hidden' name='reid' value='${data.id}'>
	ユーザー名:<br>
	<input type='text' name='rename' placeholder="NONAME"><br>
	投稿文：<br>
	<textarea name='recontent' placeholder="こちらに投稿文を記入" cols="50" rows="5"></textarea><br>
	あなたの意見は？:<br>
	<input type='radio' name='revoting' value='1' checked="checked">${data.choice1}<br>
	<input type='radio' name='revoting' value='2' >${data.choice2}<br>
	<input type='submit' value='登録'>
	</form>
    <br>

    <h3>投稿された返信スレッド</h3>

    <c:forEach var="resdata" items="${resdatabase}">
        <c:out value="${resdata.number}"/>&emsp;<c:out value="${resdata.name}"/>&emsp;<c:out value="${resdata.time}"/><br>
        <div class="th_content">
			<c:out value="${resdata.content}" escapeXml="false"/>
		</div>
        返答者の意見：<c:out value='${resdata.voting == "1" ? data.choice1:data.choice2}'/><br>
    </c:forEach>




</section>
        
</body>
</html>
        
        
        