package product.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;
import product.model.Cart;

public class AddItemHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String code = request.getParameter("NO");
		//
		String name = request.getParameter("NAME");
		String price = request.getParameter("PRICE");
		
		System.out.println("AddItemHandler name : " + name);
		System.out.println("price : " + price);
		
		if(code == null)
			throw new ServletException("상품코드가 입력되지 않았습니다. ");
		
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("CART");
		
		if(cart == null)
			cart = new Cart();
		
		cart.addItem(code, 1, name, price);
		
		System.out.println("CODE : " + cart.getName(0));
		
		session.setAttribute("CART", cart);		
		// TODO Auto-generated method stub
		return "/WEB-INF/view/AddItemToCartResult.jsp" ;		
	}
}
