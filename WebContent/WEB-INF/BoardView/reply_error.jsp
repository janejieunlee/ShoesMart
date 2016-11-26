<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="exceptionType" value="${replyException.getClass().simpleName}" />
<html>
<head><title>답변 실패</title></head>
<body> 
<c:choose>
	<c:when test="${exceptionType == 'ArticleNotFoundException'}">
	<script>
	alert("답변을 등록할 게시글이 존재하지 않습니다.");
	window.location.href="list.do?p=${param.p}";
	</script>
	</c:when>
	<c:when test="${exceptionType == 'CannotReplyArticleException'}">
	<script>
	alert("답변 글을 등록할 수 없는 게시글입니다.");
	window.location.href="list.do?p=${param.p}";
    </script>
	</c:when>
	<c:when test="${exceptionType == 'LastChildAleadyExistsException'}">
	<script>
	alert("등록할 수 있는 답변 개수를 초과했습니다.");
	window.location.href="list.do?p=${param.p}";
	</script>
	</c:when>
</c:choose>
</body>
</html>
