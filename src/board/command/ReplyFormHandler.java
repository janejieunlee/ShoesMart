package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class ReplyFormHandler implements CommandHandler {
	public String process(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		return "/WEB-INF/BoardView/reply_form.jsp";
	}
}
