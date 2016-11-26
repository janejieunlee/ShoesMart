package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.ArticleListModel;
import board.service.ListArticleService;
import mvc.command.CommandHandler;

public class ListHandler implements CommandHandler {
	public String process(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		String pageNumberString = req.getParameter("p");
		int pageNumber = 1;
		if (pageNumberString != null && pageNumberString.length() > 0) {
			pageNumber = Integer.parseInt(pageNumberString);
		}
		ListArticleService listSerivce = ListArticleService.getInstance();
		ArticleListModel articleListModel = listSerivce.getArticleList(pageNumber);
		req.setAttribute("listModel", articleListModel);
		
		if (articleListModel.getTotalPageCount() > 0) {
			int beginPageNumber = 
				(articleListModel.getRequestPage() - 1) / 10 * 10 + 1;
			int endPageNumber = beginPageNumber + 9;
			if (endPageNumber > articleListModel.getTotalPageCount()) {
				endPageNumber = articleListModel.getTotalPageCount();
			}
			req.setAttribute("beginPage", beginPageNumber);
			req.setAttribute("endPage", endPageNumber);
		}
		return "/WEB-INF/BoardView/list_view.jsp";
	}
}
