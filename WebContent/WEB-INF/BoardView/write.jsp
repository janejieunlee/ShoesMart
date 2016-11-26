<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시글 작성</title>
</head>
<body>
<script>
alert("게시글을 등록했습니다.");
window.location.href="read.do?articleId=${postedArticle.id}";
</script>
</body>
</html>