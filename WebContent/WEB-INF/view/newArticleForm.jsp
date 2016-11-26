<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>상품평 쓰기</title>
</head>

<body>
<form action="prowrite.do" method="post">
<p>
	제목:<br/><input type="text" name="title" value="${param.title}">
	<c:if test="${errors.title}">제목을 입력하세요.</c:if>
</p>
<p>
	내용:<br/>
	<textarea name="content" rows="5" cols="30">${param.title}</textarea>
</p>
<p>
    사진파일:<br/>
    
    <input type="file" name="file1" />
 
</p>
<input type="submit" value="새 글 등록">
</form>
</body>
</html>