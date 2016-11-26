package board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.Article;
import board.service.WriteArticleService;
import board.service.WritingRequest;
import mvc.command.CommandHandler;

public class WriteHandler implements CommandHandler {
	public String process(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		req.setCharacterEncoding("euc-kr");
		WritingRequest writingRequest = new WritingRequest();
		writingRequest.setWriterName(req.getParameter("writerName"));
		writingRequest.setPassword(req.getParameter("password"));
		writingRequest.setTitle(req.getParameter("title"));
		writingRequest.setContent(req.getParameter("content"));
		
		Article postedArticle = 
		WriteArticleService.getInstance().write(writingRequest);
		req.setAttribute("postedArticle", postedArticle);
		
		return "/WEB-INF/BoardView/write.jsp";
	}
}
