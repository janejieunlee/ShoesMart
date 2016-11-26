package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.Article;
import board.service.ArticleNotFoundException;
import board.service.ReadArticleService;
import mvc.command.CommandHandler;

public class UpdateFormHandler implements CommandHandler {
	public String process(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		String viewPage = null;
		try {
			int articleId = Integer.parseInt(req.getParameter("articleId"));
			Article article = ReadArticleService.getInstance().getArticle(articleId);
			viewPage = "/WEB-INF/BoardView/update_form_view.jsp";
			req.setAttribute("article", article);
		} catch (ArticleNotFoundException ex) {
			viewPage = "/article_not_found.jsp";
		}
		return viewPage;
	}
}
