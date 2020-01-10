<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.lec.beans.*" %>
<% MbDTO [] dto = (MbDTO[])session.getAttribute("login"); %>
	<c:choose>
		<c:when test="${not empty sessionScope.login}">
				<script>
					location.href = "myPage.do?mb_uid=<%= dto[0].getMb_uid() %>";
				</script>
		</c:when>
		
		<c:otherwise>
			<script>
				alert("로그인이 필요한 화면입니다.");
				location.href = "login.do";
			</script>	
		</c:otherwise>
	</c:choose> 