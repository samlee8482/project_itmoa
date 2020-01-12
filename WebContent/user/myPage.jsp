<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.lec.beans.*" %>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>MY PAGE</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/style2.css" rel="stylesheet">
<link href="css/style3.css" rel="stylesheet">

<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<script src="js/jquery.js"></script>
<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="images/ico/apple-touch-icon-144x144.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="images/ico/apple-touch-icon-114x114.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="images/ico/images/ico/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon-precomposed"
	href="images/ico/apple-touch-icon-57x57.png">

</head>
<!--/head-->


<body>

	

	<div class="w1">
		<div class="w2">
		<form id="infoForm" action="/Project_itmoa/user/myPageUpdateOk.do" method="post">
			<div class="w3">
				<img name="older_mb_img" src="${sessionScope.loginImg}" 
					style="width: 200px; height: 200px;"> 
					<input type="hidden" name="mb_img" value="${sessionScope.loginImg}" >
					<input type="file" name="profile" style="margin-left: 45%;"><br>
			</div>
	
			<p>
				<label>NAME</label> <input class="info1" type="text" id="id"
					name="mb_name" readonly value="${myPage[0].mb_name }" >
			</p>

			<br>
			
			
				<p>
					<label>Email</label> <input class="info1" type="text" id="email"
						name="mb_email" value="${myPage[0].mb_email }" >
				</p>
				<input type="hidden" name="mb_id" value="${sessionScope.loginId }" >
				<input type="hidden" name="origin_pw" id="origin_pw" value="${myPage[0].mb_pw}" >
				<input type="hidden" name="mb_uid" id="mb_uid" value="${myPage[0].mb_uid }" >
				
				<p>
					<label>Password</label> <input class="info1" id="old_pw"
						name="old_pw" type="password" required>
				</p>
				<p>
					<label>New Password</label> <input class="info1" id="pw" name="mb_pw"
						type="password" required>
				</p>
				<p>
					<label>Confirm</label> <input class="info1" type="password" name="mb_pw"
						id="pw2" type="password" required>
				</p>
				<p>
					<label>ADDRESS</label> 
					<input type="text" id="sample6_postcode" name="mb_zip" value="${myPage[0].mb_zip }"
						style="width: 250px; height: 40px; border-radius: 7px; margin: 5px;">
					<input class="addr-btn" type="button"
						onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
					<input class="addr" type="text" id="sample6_address" name="mb_add1"
						value="${myPage[0].mb_add1 }"><br> 
					<input class="addr" name="mb_add2"
						type="text" id="sample6_detailAddress"value="${myPage[0].mb_add2 }">
					<input class="addr" type="text" id="sample6_extraAddress"
						style="display: none;" placeholder="상세주소">
				</p>
				<p class="w3-center">
					<button type="submit" id="join-btn">정보 수정</button>
				</p>
			</form>
			
			<div class="zzim-list" id="zzim-list" style="margin-left: 37%; text-align: center;">
				<table>
					<tr>
						<th>NO</th>
						<th>학원명</th>
						<th>과정명</th>
					</tr>
				<c:forEach var="dto" items="${myPageZzim }">
				
					<tr>
					
						<td>${dto.zzim_uid }</td>
						<td>${dto.ins_name }</td>
						<td>${dto.cur_name }
						<form action="zzimDeleteOk.do">
						<input type="submit" value="삭제" style="float:right;">
						<input type="hidden" name="zzim_uid" value="${dto.zzim_uid }">
						<input type="hidden" name="ifZZim" value="true" />
						<input type="hidden" name="mb_uid" value="${myPage[0].mb_uid }">
						<input type="hidden" name="goBack" value="${myPage[0].mb_uid }" />
						</form></td>
					</tr>
				
				</c:forEach>
				
						<!--  <a href='view.do?uid=" + arr[i].getMb_uid() + "'>"-->
				
				</table>
			</div>
		</div>
	</div>


	<script
		src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		function sample6_execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

							// 각 주소의 노출 규칙에 따라 주소를 조합한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var addr = ''; // 주소 변수
							var extraAddr = ''; // 참고항목 변수

							//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
							if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
								addr = data.roadAddress;
							} else { // 사용자가 지번 주소를 선택했을 경우(J)
								addr = data.jibunAddress;
							}

							// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
							if (data.userSelectedType === 'R') {
								// 법정동명이 있을 경우 추가한다. (법정리는 제외)
								// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
								if (data.bname !== ''
										&& /[동|로|가]$/g.test(data.bname)) {
									extraAddr += data.bname;
								}
								// 건물명이 있고, 공동주택일 경우 추가한다.
								if (data.buildingName !== ''
										&& data.apartment === 'Y') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
								if (extraAddr !== '') {
									extraAddr = ' (' + extraAddr + ')';
								}
								// 조합된 참고항목을 해당 필드에 넣는다.
								document.getElementById("sample6_extraAddress").value = extraAddr;

							} else {
								document.getElementById("sample6_extraAddress").value = '';
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('sample6_postcode').value = data.zonecode;
							document.getElementById("sample6_address").value = addr;
							// 커서를 상세주소 필드로 이동한다.
							document.getElementById("sample6_detailAddress")
									.focus();
						}
					}).open();
		}
	</script>
	<script>
		$(function info_submit() {
			if ($("#infoForm").submit(function() {
				if ($("#pw").val() !== $("#pw2").val()) {
					alert("비밀번호가 다릅니다.");
					$("#pw").val("").focus();
					$("#pw2").val("");
					return false;
				}else if ($("#pw").val().length < 8) {
					alert("비밀번호는 8자 이상으로 설정해야 합니다.");
					$("#pw").val("").focus();
					return false;
				} else if ($.trim($("#pw").val()) !== $("#pw").val()) {
					alert("공백은 입력이 불가능합니다.");
					return false;
				}
				
				if ($("#origin_pw").val() !== $("#old_pw").val()) {
					alert("기존 비밀번호가 다릅니다.");
					$("#old_pw").val("").focus();
					$("#pw").val("");
					$("#pw2").val("");
					return false;
				}else{
					location.href="myPageUpdateOk.do";
				}
			 
			
			}))
				;
		})
	</script>
	


	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/init.js"></script>
</body>

</html>
</body>
</html>


