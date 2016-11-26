<%@ page contentType="text/html; charset=euc-kr" %>
<html>
<head><title>글 수정</title></head>
<body>
<script>
alert("글을 수정했습니다.");
window.location.href="read.do?articleId=${updatedArticle.id}&p=${param.p}";
</script>
</body>
</html>
