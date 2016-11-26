<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Bootstrap Example</title>
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
   		<form action="join.do" method="post" >
   		<table border="1" align="center">
   			<tr>
   				<td colspan="2" align="center">
   					<b><font size=5>회원가입 페이지</font></b>
   				</td>
			</tr>
			<tr><td>아이디: <input type="text" name="id" value="${param.id}" >
				<c:if test="${errors.id}">ID를 입력하세요.</c:if>
				<c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if>
			</td></tr>
			<tr><td>
				이름: <input type="text" name="name" value="${param.name}">
				<c:if test="${errors.name}">이름을 입력하세요.</c:if>
			</td></tr>
			<tr><td>
				암호: <input type="password" name="password">
				<c:if test="${errors.password}">암호를 입력하세요.</c:if>
			</td></tr>
			<tr><td>
				확인: <input type="password" name="confirmPassword">
				<c:if test="${errors.confirmPassword}">확인을 입력하세요.</c:if>
				<c:if test="${errors.notMatch}">암호와 확인이 일치하지 않습니다.</c:if>
			</td></tr>
			<tr><td>
				전화번호: <input type="text" name="phone" value="${param.phone}" size="30" >
				<c:if test="${errors.phone}">이름을 입력하세요.</c:if>
			</td></tr>
			<tr><td>
				주소: <input type="text" name="address" value="${param.address}" size="50" >
				<c:if test="${errors.name}">이름을 입력하세요.</c:if>
			</td></tr>
			<tr><td>
				e-mail: <input type="text" name="email" value="${param.email}" size="30">
				<c:if test="${errors.name}">이름을 입력하세요.</c:if>
			</td></tr>
						<tr><td>
				적립금: <input type="text" name="money" value="${param.money}" >
				<c:if test="${errors.money}">이름을 입력하세요.</c:if>
			</td></tr>
			<tr><td colspan="2" align=center>
				<input type="submit" value="가입">
				</td></tr>
				</table>
			</form>
			
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