<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Bootstrap Example</title>
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
			<li>${authUser.name}님, 안녕하세요.</li>
			<li><a href="logout.do">로그아웃</a></li>
			<li><a href="changePwd.do">정보수정</a></li>
		</u:isLogin>
		<u:notLogin>
			<li><a href="join.do">회원가입</a></li>
			<li><a href="login.do">로그인</a></li>
		</u:notLogin> 
        <li><a href="list.do">고객게시판</a></li>
        <li><a href="prolist.do">상품평게시판</a>
        <li><A HREF="cartList.do">장바구니</A></li>
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
       <p><a href="listProduct.do">상품</a></p>
    </div>
    <div class="col-sm-8 text-left">





<div class="container">
<h2>글쓰기</h2>
<form action="write.do" method="post"
class="form-horizontal" role="form">
<div class="form-group">
<label class="control-label col-sm-2" for="title">제목:</label>
<div class="col-sm-10"> 
<input type="text" class="form-control" name="title" placeholder="Enter title"/>
</div>
</div>
<div class="form-group">
<label class="control-label col-sm-2" for="writer">작성자:</label>
<div class="col-sm-10">
<input type="text" class="form-control" name="writerName" placeholder="Enter writerName"/>
</div>
</div>

<div class="form-group">
<label class="control-label col-sm-2" for="password">글암호:</label>
<div class="col-sm-10">
<input type="password" class="form-control" name="password" placeholder="Enter password"/>
</div>
</div>
<div class="form-group">
<label for="comment">글내용:</label>
<textarea name="content" rows="5" class="form-control"></textarea>
</div>
<input type="submit" value="확인" />
</form>






</div>
    </div>
    <div class="col-sm-2 sidenav">
      <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>