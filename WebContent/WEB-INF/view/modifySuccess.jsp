<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խñ� ����</title>
</head>
<body>

�Խñ��� �����߽��ϴ�.
<br>
${ctxPath = pageContext.request.contextPath ; ''}
<a href="${ctxPath}/prolist.do">[�Խñ۸�Ϻ���]</a>
<a href="${ctxPath}/proread.do?no=${modReq.articleNumber}">[�Խñ۳��뺸��]</a>
</body>
</html>