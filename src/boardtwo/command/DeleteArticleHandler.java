package boardtwo.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardtwo.service.DeleteArticleService;
import mvc.command.CommandHandler;

public class DeleteArticleHandler implements CommandHandler{
	private DeleteArticleService deleteService = new DeleteArticleService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) 
			throws Exception {
		System.out.println("DeleteArticleHandler");
		String strNo = req.getParameter("no");
		System.out.println("pageNoVal : " + strNo);
		int pageNo = 1;
		if (strNo != null) {
			pageNo = Integer.parseInt(strNo);
		}
		int result = deleteService.getArticlePage(pageNo);
		req.setAttribute("result", result);
		return "/WEB-INF/view/deleteArticle.jsp";
	}


}
