<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��ǰ�� ����</title>
</head>

<body>
<form action="prowrite.do" method="post">
<p>
	����:<br/><input type="text" name="title" value="${param.title}">
	<c:if test="${errors.title}">������ �Է��ϼ���.</c:if>
</p>
<p>
	����:<br/>
	<textarea name="content" rows="5" cols="30">${param.title}</textarea>
</p>
<p>
    ��������:<br/>
    
    <input type="file" name="file1" />
 
</p>
<input type="submit" value="�� �� ���">
</form>
</body>
</html>