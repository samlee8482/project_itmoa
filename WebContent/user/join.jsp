<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>JOIN</title>
   
</head><!--/head-->
<body>

	<!-- TopMenu -->
	<jsp:include page="topMenu.jsp"/>
        
        <script>
        // form 검증
    	function chkSubmit(){
    		frm = document.forms["frm"];
    		
    		var mb_id = frm["mb_id"].value.trim();
    		var mb_pw = frm["mb_pw"].value.trim();
    		var mb_pwOk = frm["mb_pwOk"].value.trim();
    		var mb_email = frm["mb_email"].value.trim();
    		var mb_zip = frm["mb_zip"].value.trim();
    		var mb_add1 = frm["mb_add1"].value.trim();
    		var mb_add2 = frm["mb_add2"].value.trim();
    		var mb_name = frm["mb_name"].value.trim();
    		
    		if(mb_name == ""){
    			alert("이름 입력해주세요");
    			frm["mb_name"].focus();
    			return false;
    		}
    		if(mb_id == ""){
    			alert("아이디를 입력해주세요");
    			frm["mb_id"].focus();
    			return false;
    		}
    		if(mb_pw == ""){
    			alert("비밀번호를 입력해주세요.");
    			frm["mb_pw"].focus();
    			return false;
    		} 
    		if(mb_pwOk == ""){
    			alert("비밀번호를 입력해주세요.");
    			frm["mb_pwOk"].focus();
    			return false;
    		} 
    		if(mb_email == ""){
    			alert("이메일을 입력해주세요.");
    			frm["mb_email"].focus();
    			return false;
    		}
    		if(mb_zip == ""){
    			alert("우편번호를 입력해주세요.");
    			frm["mb_zip"].focus();
    			return false;
    		} 
    		if(mb_add1 == ""){
    			alert("주소를 입력해주세요.");
    			frm["mb_add1"].focus();
    			return false;
    		} 
    		if(mb_add2 == ""){
    			alert("주소를 입력해주세요.");
    			frm["mb_add2"].focus();
    			return false;
    		} 
    		
    		
    			return true;
    	}
        </script>
        
    </header><!--/header-->
    <form id="join-content" action="joinOk.jsp" name="frm" method="post" onsubmit="return chkSubmit()">
    <div id="join-info">
    	<div id="info1">
    		이름 <br><input class="info1" id="name" name="mb_name" type="text" placeholder="이름을 입력해주세요."><br>
    		아이디<br> <input class="info1 id="id" name="mb_id" type="text" placeholder="아이디를 입력해주세요."><br>
    		비밀번호<br> <input class="info1 id="pw" name="mb_pw" type="text" placeholder="비밀번호 를 입력해주세요."><br>
    		비밀번호 확인<br> <input class="info1 id="pwcheck" name="mb_pwOk" type="text" placeholder="비밀번호를 입력해주세요."><br>
    		e-mail<br> <input class="info1 id="email" name="mb_email" type="text" placeholder="이메일을 입력해주세요."><br>
    	</div>
    	<div id="info_addr">
	    	주소<br>
	    	<input type="text" id="sample6_postcode" name="mb_zip" placeholder="우편번호" style="width: 250px;height: 40px;border-radius: 7px;margin: 5px;">
			<input class="addr-btn" type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
			<input class="addr" type="text" id="sample6_address" name="mb_add1" placeholder="주소"><br>
			<input class="addr" type="text" id="sample6_detailAddress" name="mb_add2" placeholder="상세주소">
			<input class="addr" type="text" id="sample6_extraAddress" style="display: none;" placeholder="참고항목">
    	</div>
    	<input id="join-btn" type="submit" value="회원가입">
    </div>
    </form>
    
    
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
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
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
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
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
 
 
</script>

	 


 
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/init.js"></script>
</body>
</html>