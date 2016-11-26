package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.Article;
import board.service.UpdateArticleService;
import board.service.UpdateRequest;
import mvc.command.CommandHandler;

public class UpdateHandler implements CommandHandler{
	public String process(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		req.setCharacterEncoding("euc-kr");
		UpdateRequest updateRequest = new UpdateRequest();
		int articleId = Integer.parseInt(req.getParameter("articleId"));
		updateRequest.setArticleId(articleId);
		updateRequest.setTitle(req.getParameter("title"));
		updateRequest.setContent(req.getParameter("content"));
		updateRequest.setPassword(req.getParameter("password"));
		
		String viewPage = null;
		try {
			Article article = UpdateArticleService.getInstance().
					update(updateRequest);
			req.setAttribute("updatedArticle", article);
			viewPage = "/WEB-INF/BoardView/update_success.jsp";
		} catch (Exception ex) {
			req.setAttribute("updateException", ex);
			viewPage = "/WEB-INF/BoardView/update_error.jsp";
		}
		return viewPage;
	}

}
