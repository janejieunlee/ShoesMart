package guestbook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.model.Message;
import guestbook.service.WriteMessageService;
import mvc.command.CommandHandler;

public class WriteMessageHandler implements CommandHandler{
	public String process(HttpServletRequest req, HttpServletResponse res)
	throws Exception{
		req.setCharacterEncoding("utf-8");
		
		Message message = new Message();
		message.setGuestName(req.getParameter("guestName"));
		message.setPassword(req.getParameter("password"));
		message.setMessage(req.getParameter("message"));
		
		WriteMessageService writeService = WriteMessageService.getInstance();
		writeService.write(message);
		
		return "/WEB-INF/guestView/writeMessage.jsp";
	}
}
