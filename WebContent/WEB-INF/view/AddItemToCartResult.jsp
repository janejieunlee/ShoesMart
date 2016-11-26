<%@page contentType="text/html; charset=utf-8"%>
<%@ page import="product.model.Cart" %>

<HTML>
    <HEAD><TITLE>장바구니 담기</TITLE></HEAD>
    <BODY>
    <%!
    	Cart cart = new Cart();
    %>
    <%	
    
    	cart = (Cart) session.getAttribute("CART"); 
    	System.out.println("JSP CART : " + cart.getCode(0));
    %>
        <H4>장바구니 담기</H4>
        	상품을 담았습니다.<BR><BR>
        <A href='#' onClick='self.close()'>닫기</A>
    </BODY>
</HTML>
