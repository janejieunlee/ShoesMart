package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.model.Message;
import guestbook.service.DeleteMessageService;
import guestbook.service.InvalidPassowrdException;
import mvc.command.CommandHandler;

public class DeleteMessageHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		
		Message messgae = new Message();
		
		int messageId = Integer.parseInt(req.getParameter("messageId"));
		String password = req.getParameter("password");
		boolean invalidPassowrd = false;
		
		String viewPage = null;
		try{
			DeleteMessageService deleteService = DeleteMessageService.getInstance();
			deleteService.deleteMessage(messageId, password);
		}catch(InvalidPassowrdException ex){
			invalidPassowrd = true;
		}
		
		return "/WEB-INF/view/readProduct.jsp";
	}
}
