package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.DeleteArticleService;
import board.service.DeleteRequest;
import mvc.command.CommandHandler;

public class DeleteHandler implements CommandHandler {
	public String process(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		req.setCharacterEncoding("euc-kr");
		DeleteRequest deleteRequest = new DeleteRequest();
		int articleId = Integer.parseInt(req.getParameter("articleId"));
		deleteRequest.setArticleId(articleId);
		deleteRequest.setPassword(req.getParameter("password"));
		
		String viewPage = null;
		try {
			DeleteArticleService.getInstance().deleteArticle(deleteRequest);
			viewPage = "/WEB-INF/BoardView/delete_success.jsp";
		} catch (Exception ex) {
			req.setAttribute("deleteException", ex);
			viewPage = "/WEB-INF/BoardView/delete_error.jsp";
		}
		return viewPage;
	}

}
