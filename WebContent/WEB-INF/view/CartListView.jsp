<%@page contentType="text/html; charset=euc-kr"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<jsp:useBean id="cartList" class="product.model.CartList"/>
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
      <p><a href="nike-list">Nike</a></p>
      <p><a href="adidas-list">Adidas</a></p>
      <p><a href="newbalance-list">New Balance</a></p>
    -->
           <p><a href="listProduct.do">상품</a></p>
    </div>
    <div class="col-sm-8 text-left">

<H4>장바구니 관리</H4>
<c:choose> 
    <c:when test="${CART_LIST == null || CART_LIST.size <= 0}">
        장바구니가 비어 있습니다.
    </c:when>
    <c:otherwise>
        <TABLE border=1>
            <TR>
                <TD width=70>상품코드</TD>
                <TD width=250>상품명</TD>
                <TD width=80>단가</TD>
                <TD width=50>수량</TD>
                <TD width=100>금액</TD>
                <!-- 
                <TD width=50>사이즈</TD>
            	-->
            </TR>
            <c:forEach var="cnt" begin="0" end="${CART_LIST.size - 1}"> 
                <TR>
                    <TD>${CART_LIST.code[cnt]}</TD>
                    <TD>${CART_LIST.name[cnt]}</TD>
                    <TD>${CART_LIST.price[cnt]}원</TD>
                    <TD>${CART_LIST.number[cnt]}
                    <!--
                    	<select name="amount">
							<option value="0">0</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
						</select>
                    -->
                    </TD>
                    <TD>${CART_LIST.price[cnt] * CART_LIST.number[cnt]}원</TD>
                    <!-- 
                    <TD>		
                    	<select name="size">
							<option value="230">230</option>
							<option value="235">235</option>
							<option value="240">240</option>
							<option value="245">245</option>
							<option value="250">250</option>
							<option value="255">255</option>
							<option value="260">260</option>
							<option value="265">265</option>
							<option value="270">270</option>
							<option value="275">275</option>
							<option value="280">280</option>
						</select>
					</TD>
					-->
                </TR>
           </c:forEach> 
        </TABLE>
        
        <!-- 
        <FORM ACTION=payment METHOD=POST>
        -->
        <form action=pay.do method=post>    
            총계: ${CART_LIST.totalAmount}원  
            		<INPUT TYPE=HIDDEN NAME=TOTAL_AMOUNT VALUE='${CART_LIST.totalAmount}' >
            		<input type=hidden name=USER_ID value='${authUser.id}'>
            		<u:isLogin>
						<INPUT TYPE=SUBMIT VALUE='결제하기' />
					</u:isLogin>
					<u:notLogin>	
						<a href="login.do"><input type='button' value='결제하기'/></a>
			</u:notLogin>           
        </form> 
    </c:otherwise>
</c:choose> 





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