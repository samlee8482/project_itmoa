<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${myPageUpdateOk == 0}">
		<script>
			alert("변경된 정보가 없습니다.");
		</script>
	</c:when>
	
	<c:otherwise>
		<script>
			alert("정보가 변경되었습니다.");
		</script>
	</c:otherwise>
</c:choose>
