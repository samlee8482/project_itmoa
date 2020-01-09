<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.*" %>

<%--
	String sessionName, sessionValue;
	Enumeration<String> enumeration =  session.getAttributeNames(); // session의  name들 리턴

	int i = 0;
	while(enumeration.hasMoreElements()) {
		sessionName = enumeration.nextElement(); // 세션 name
		sessionValue = (String)session.getAttribute(sessionName);
		out.println((i+1) + "]" + sessionName + ":" + sessionValue + "<br>");
		i++;
	}
	if(i==0){
		out.println("세션이 없습니다<br>");
	}
	
--%>

	<c:choose>
		<c:when test="${not empty sessionScope.login}">
		<c:choose>
			<c:when test="${fn:length(loginOk) == 1 && loginOk[0].mb_level <= 2}">	
				<script>
					alert("로그인성공 사용자");
					location.href = "index.html";
				</script>
			</c:when>	
			
			<c:when test="${fn:length(loginOk) == 1 && loginOk[0].mb_level == 3}">	
				<script>
					alert("로그인성공 관리자");
					location.href = "/Project_itmoa/admin/adminMemberList.do";
				</script>
			</c:when>	
			</c:choose>
		</c:when>
		
		<c:otherwise>
			<script>
				alert("로그인실패");
				history.back();
			</script>	
		</c:otherwise>
		
		
	</c:choose>
	