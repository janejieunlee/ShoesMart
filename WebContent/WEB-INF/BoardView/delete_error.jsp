<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="exceptionType" value="${deleteException.getClass().simpleName}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ����</title>
</head>
<body>
<c:choose>
	<c:when test="${exceptionType=='ArticleNotFoundException'}">
	<script>
	alert("������ �Խñ��� �������� �ʽ��ϴ�.");
	window.location.href="list.do";
	</script>
	</c:when>
	<c:when test="${exceptionType=='InvalidPasswordException'}">
	<script>
	alert("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
	window.location.href="list.do";
	</script>
	</c:when>
</c:choose>

</body>
</html>