package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.Article;
import board.service.ArticleNotFoundException;
import board.service.ReadArticleService;
import mvc.command.CommandHandler;

public class ReadHandler implements CommandHandler {
	public String process(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		int articleId = Integer.parseInt(req.getParameter("articleId"));
		String viewPage = null;
		try {
			Article article = ReadArticleService.getInstance().readArticle(articleId);
			req.setAttribute("article", article);
			viewPage = "/WEB-INF/BoardView/read_view.jsp";
		} catch(ArticleNotFoundException ex) {
			viewPage = "/article_not_found.jsp";
		}
		return viewPage;
	}

}
