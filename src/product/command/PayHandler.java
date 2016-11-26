package product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;
import product.service.PayProduct;
import product.service.PayService;

public class PayHandler implements CommandHandler {
	
	//private static final String FORM_VIEW = "/WEB-INF/view/payTest.jsp";
	private PayService payService = new PayService();
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String totalamount = (String) request.getParameter("TOTAL_AMOUNT");
		String user_id = (String) request.getParameter("USER_ID");
		int money = Integer.parseInt(totalamount);
		
		System.out.println("PayHandler totalamount : " + totalamount);
		System.out.println("PayHandler userid : " + user_id);
		System.out.println("PayHandler numTotalAmount : " + money);
		
		
		PayProduct payProduct = payService.getPayProduct(money, user_id);
		boolean result = payService.payResultMethod();
		System.out.println("PayHandler result : " + result);
		
		
		if(result == false){
			return "/WEB-INF/view/payFail.jsp";
		} else{
			return "/WEB-INF/view/paySuccess.jsp";
		}
	}
}
