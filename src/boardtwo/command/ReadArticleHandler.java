package boardtwo.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardtwo.service.ArticleContentNotFoundException;
import boardtwo.service.ArticleData;
import boardtwo.service.ArticleNotFoundException;
import boardtwo.service.ReadArticleService;
import mvc.command.CommandHandler;

public class ReadArticleHandler implements CommandHandler {
	private ReadArticleService readService = new ReadArticleService();

	public String process(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		System.out.println("ReadArticleHandler");
		String noVal = req.getParameter("no");
		int articleNum = Integer.parseInt(noVal);
		try {
			ArticleData articleData = readService.getArticle(articleNum, true);
			req.setAttribute("articleData", articleData);
			return "/WEB-INF/view/readArticle.jsp";
		} catch (ArticleNotFoundException | ArticleContentNotFoundException e) {
			req.getServletContext().log("no article", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return "/WEB-INF/view/test.jsp";
		}
	}

}
