package product.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;
import product.dao.CartDao;
import product.model.Cart;
import product.model.CartList;
import product.service.CartListService;
import product.service.ProductNotFoundException;

public class CartListHandler implements CommandHandler{
	//안되면 NewFile.jsp로 바꾸기
	private static final String FORM_VIEW = "/WEB-INF/view/CartListView.jsp";	

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("CART");
	
		if (cart != null) {
			
			CartList cartList = new CartList();
			
			int itemNum = cart.getSize();
			for(int cnt=0; cnt<itemNum; cnt++){
				String code = cart.getCode(cnt);
				int number = cart.getNumber(cnt);
				String name = cart.getName(cnt);
				int price = Integer.parseInt(cart.getPrice(cnt));
				
				cartList.setCode(cnt, code);
				cartList.setName(cnt, name);
				cartList.setPrice(cnt, price);
				cartList.setNumber(cnt, number);
				//임의의 값을 넣어줬음
			}		
			
			request.setAttribute("CART_LIST", cartList);
		}else {
			request.setAttribute("CART_LIST", null);
		}	
		RequestDispatcher dispatcher = request.getRequestDispatcher(FORM_VIEW);
		dispatcher.forward(request, response);
		return null;		
	}	
}
