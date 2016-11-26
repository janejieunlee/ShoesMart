package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.Article;
import board.service.ReplyArticleService;
import board.service.ReplyingRequest;
import mvc.command.CommandHandler;

public class ReplyHandler implements CommandHandler{
	public String process(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		req.setCharacterEncoding("euc-kr");
		ReplyingRequest replyingRequest = new ReplyingRequest();
		int parentArticleId = Integer.parseInt(req.getParameter("parentArticleId"));
		replyingRequest.setParentArticleId(parentArticleId);
		replyingRequest.setWriterName(req.getParameter("writerName"));
		replyingRequest.setPassword(req.getParameter("password"));
		replyingRequest.setTitle(req.getParameter("title"));
		replyingRequest.setContent(req.getParameter("content"));
		
		String viewPage = null;
		try {
			Article postedArticle = ReplyArticleService.getInstance().
					reply(replyingRequest);
			req.setAttribute("postedArticle", postedArticle);
			viewPage = "/WEB-INF/BoardView/reply_success.jsp";
		} catch(Exception ex) {
			viewPage = "/WEB-INF/BoardView/reply_error.jsp";
			req.setAttribute("replyException", ex);
		}
		return viewPage;
	}
}
