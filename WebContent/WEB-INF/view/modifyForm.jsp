<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խñ� ����</title>
</head>
<body>
<form action="promodify.do" method="post">
<input type="hidden" name="no" value="${modReq.articleNumber}">
<p>
	��ȣ:<br/>${modReq.articleNumber}
</p>
<p>
	����:<br/><input type="text" name="title" value="${modReq.title}">
	<c:if test="${errors.title}">������ �Է��ϼ���.</c:if>
</p>
<p>
	����:<br/>
	<textarea name="content" rows="5" cols="30">${modReq.content}</textarea>
</p>
<input type="submit" value="�� ����">
</form>
</body>
</html>