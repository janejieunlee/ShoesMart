<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="exceptionType" value="${updateException.getClass().simpleName}" />
<html>
<head><title>수정 실패</title></head>
<body>
에러: 
<c:choose>
	<c:when test="${exceptionType == 'ArticleNotFoundException'}">
	<script>
	alert("수정할 게시글이 존재하지 않습니다.");
	window.location.href="list.do?p=${param.p}";
	</script>
	</c:when>
	<c:when test="${exceptionType == 'InvalidPasswordException'}">
	<script>
	alert("암호를 잘못 입력하셨습니다.");
	window.location.href="list.do?p=${param.p}";
	</script>
	</c:when>
</c:choose>


</body>
</html>
