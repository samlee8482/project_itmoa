<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="logout" value="${sessionScope.login }" />
<c:remove var="logout"/>
<c:choose>
		<c:when test="${empty sessionScope.login }">
					<script>
						alert("로그아웃 되었습니다");
						location.href="login.jsp";
					</script>
		</c:when>	
</c:choose>
