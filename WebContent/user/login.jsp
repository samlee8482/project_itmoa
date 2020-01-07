<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>LOGIN</title>
</head>
<!--/head-->
<script>
	// form 검증
	function chkSubmit(){
		frm = document.forms["frm"];
		
		var id = frm["id"].value.trim();
		var pw = frm["pw"].value.trim();
		
		if(iw == ""){
			alert("아이디를 입력해주세요");
			frm["id"].focus();
			return false;
		}
		if(pw == ""){
			alert("비밀번호를 입력해주세요.");
			frm["pw"].focus();
			return false;
		}
		
		return true;
	}
</script>
<body>
	<!-- TopMenu -->
	<jsp:include page="topMenu.jsp"/>
	
	<form name="frm" id="login-content" method="get" action="loginOk.jsp"
		onsubmit="return chkSubmit()">
		<div class="login-logo">
			<img id="logo" src="images/fake-logo.PNG">
		</div>
		<div id="login-info" class="login-info">
			<div id="id-pw">
				<input name="id" class="login-info" type="text" placeholder="아이디"
					required="required"><br> <input name="pw"
					class="login-info" type="text" placeholder="비밀번호"
					required="required">
			</div>
			<button type="submit" id="login-btn">로그인</button>
		</div>
		<hr>
		<div id="other-op">
			<a href="findID_PW.html"> 아이디 찾기 </a> | <a
				href="findID_PW.html#div-find-pw">비밀번호 찾기</a><br> <a
				href="join.html">회원가입</a>
		</div>
	</form>


	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/init.js"></script>
</body>
</html>
