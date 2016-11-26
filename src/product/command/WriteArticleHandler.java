package product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import product.service.WriteProductService;

public class WriteArticleHandler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/view/newProductForm.jsp";
	private WriteProductService productService = new WriteProductService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
