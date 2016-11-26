<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="guestbook.service.MessageListView"%>
<%@page import="guestbook.service.GetMessageListService"%>
<%@page import="guestbook.model.Message" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<%
	String pageNumberStr = request.getParameter("page");
	int pageNumber = 1;
	if(pageNumberStr != null){
		pageNumber = Integer.parseInt(pageNumberStr);
	}
	
	GetMessageListService messageListService =
			GetMessageListService.getInstance();
	MessageListView viewData =
			messageListService.getMessageList(pageNumber);
%>
<c:set var="viewData"  value="<%= viewData %>"/>
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
        <h2>상세 페이지</h2>
        	<center>
				<table border="1" width="500px">
				<tr>
					<td>상품 번호</td>
					<td>${productData.product.number}</td>
				</tr>
				<!-- 
				<tr>
					<td>작성자</td>
					<td>${productData.product.writer.name}</td>
				</tr>
				 -->
				<tr>
					<td>상품명</td>
					<td><c:out value='${productData.product.name}' /></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><u:pre value='${productData.content}'/></td>
				</tr>
				<tr>
					<td colspan="2">
						<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" />
						<a href="listProduct.do?pageNo=${pageNo}">상품 목록 보기</a>
						<!-- 
						<c:if test="${authUser.id == productData.product.writer.id}">
						<a href="modify.do?no=${productData.product.number}">[게시글수정]</a>
						<a href="delete.do?no=${productData.product.number}">[게시글삭제]</a>
						</c:if>
						-->
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button onClick='window.open("additem.do?NO=${param.no}&NAME=${productData.product.name}&PRICE=${productData.content}","cart_result", "width=400,height=150").focus()'>
						장바구니 담기</button>
						
					</td>
				</tr>
				</table>
						<hr>
		상품평 남기기
		
		<form action="writeMessage.do" method="post">
	이름: <input type="text" name="guestName"><br>
	암호: <input type="password" name="password"><br>
	상품평: <br><textarea name="message" rows="5" cols="80"></textarea><br>
	<input type="submit" value="상품평 남기기"/>
	</form>
	<hr>
	<c:if test="${viewData.isEmpty()}">
	등록된 메시지가 없습니다.
	</c:if>
	
	<c:if test="${!viewData.isEmpty()}">
	<table border="1" width="500px">
		<c:forEach var="message" items="${viewData.messageList}">
		<tr>
			<td>
			상품평 번호:${message.id}<br/>
			손님 이름:${message.guestName}<br/>
			상품평:${message.message}<br/>
			<a href="confirmDeletion.jsp?messageId=${message.id}">[삭제하기]</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<c:forEach var="pageNum" begin="1" end="${viewData.pageTotalCount}">
	<a href="readProduct.jsp?page=${pageNum}">[${pageNum}]</a>
	</c:forEach>
	</c:if>
			</center>
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
