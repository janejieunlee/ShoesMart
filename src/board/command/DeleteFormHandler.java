package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class DeleteFormHandler implements CommandHandler {
	public String process(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		return "/WEB-INF/BoardView/delete_form.jsp";
	}
}
