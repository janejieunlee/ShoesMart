<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="exceptionType" value="${replyException.getClass().simpleName}" />
<html>
<head><title>�亯 ����</title></head>
<body> 
<c:choose>
	<c:when test="${exceptionType == 'ArticleNotFoundException'}">
	<script>
	alert("�亯�� ����� �Խñ��� �������� �ʽ��ϴ�.");
	window.location.href="list.do?p=${param.p}";
	</script>
	</c:when>
	<c:when test="${exceptionType == 'CannotReplyArticleException'}">
	<script>
	alert("�亯 ���� ����� �� ���� �Խñ��Դϴ�.");
	window.location.href="list.do?p=${param.p}";
    </script>
	</c:when>
	<c:when test="${exceptionType == 'LastChildAleadyExistsException'}">
	<script>
	alert("����� �� �ִ� �亯 ������ �ʰ��߽��ϴ�.");
	window.location.href="list.do?p=${param.p}";
	</script>
	</c:when>
</c:choose>
</body>
</html>
