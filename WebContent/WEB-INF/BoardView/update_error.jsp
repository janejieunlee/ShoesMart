<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="exceptionType" value="${updateException.getClass().simpleName}" />
<html>
<head><title>���� ����</title></head>
<body>
����: 
<c:choose>
	<c:when test="${exceptionType == 'ArticleNotFoundException'}">
	<script>
	alert("������ �Խñ��� �������� �ʽ��ϴ�.");
	window.location.href="list.do?p=${param.p}";
	</script>
	</c:when>
	<c:when test="${exceptionType == 'InvalidPasswordException'}">
	<script>
	alert("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
	window.location.href="list.do?p=${param.p}";
	</script>
	</c:when>
</c:choose>


</body>
</html>
