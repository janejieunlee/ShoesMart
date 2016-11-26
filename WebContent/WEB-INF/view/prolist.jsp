<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��ǰ�� ���</title>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;}
    }
  </style>
<style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
</style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
	   <a class="navbar-brand" href="index.jsp">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.jsp">Home</a></li>        
		 <u:isLogin>
			<li>${authUser.name}��, �ȳ��ϼ���.</li>
			<li><a href="logout.do">�α׾ƿ�</a></li>
			<li><a href="changePwd.do">��������</a></li>
		</u:isLogin>
		<u:notLogin>
			<li><a href="join.do">ȸ������</a></li>
			<li><a href="login.do">�α���</a></li>
		</u:notLogin> 
        <li><a href="list.do">���Խ���</a></li>
        <li><a href="prolist.do">��ǰ��Խ���</a>
        <li><A HREF="cartList.do">��ٱ���</A></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">
  <div class="row content">
    <div class="col-sm-2 sidenav">
    <!-- 
      <p><a href="nike.do">Nike</a></p>
      <p><a href="adidas-list">Adidas</a></p>
      <p><a href="newbalance-list">New Balance</a></p>
       -->
       <p><a href="listProduct.do">��ǰ</a></p>
    </div>
    <div class="col-sm-8 text-left">
<body>
<table border="1">
	<tr>
		<td colspan="4"><a href="prowrite.do">[�Խñ۾���]</a></td>
	</tr>
	<tr>
		<td>��ȣ</td>
		<td>����</td>
		<td>�ۼ���</td>
		<td>��ȸ��</td>
	</tr>
<c:if test="${articlePage.hasNoArticles()}">
	<tr>
		<td colspan="4">�Խñ��� �����ϴ�.</td>
	</tr>
</c:if>
<c:forEach var="article" items="${articlePage.content}">
	<tr>
		<td>${article.number}</td>
		<td>
		<a href="proread.do?no=${article.number}&pageNo=${articlePage.currentPage}">
		<c:out value="${article.title}"/>
		</a>
		</td>
		<td>${article.writer.name}</td>
		<td>${article.readCount}</td>
	</tr>
</c:forEach>
<c:if test="${articlePage.hasArticles()}">
	<tr>
		<td colspan="4">
			<c:if test="${articlePage.startPage > 5}">
			<a href="proread.do?pageNo=${articlePage.startPage - 5}">[����]</a>
			</c:if>
			<c:forEach var="pNo" 
					   begin="${articlePage.startPage}" 
					   end="${articlePage.endPage}">
			<a href="proread.do?pageNo=${pNo}">[${pNo}]</a>
			</c:forEach>
			<c:if test="${articlePage.endPage < articlePage.totalPages}">
			<a href="proread.do?pageNo=${articlePage.startPage + 5}">[����]</a>
			</c:if>
		</td>
	</tr>
</c:if>
</table>

</body>
</html>