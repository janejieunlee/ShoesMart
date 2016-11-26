<%@ page contentType="text/html; charset=euc-kr" %>
<html>
<head><title>답변글 작성</title></head>
<body>
<script>
alert("답변글을 등록했습니다.");
window.location.href="read.do?articleId=${postedArticle.id}&p=${param.p}";
</script>

</body>
</html>
