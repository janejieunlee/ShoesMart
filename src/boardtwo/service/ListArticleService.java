package boardtwo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import boardtwo.dao.ArticleDao;
import boardtwo.model.Article2;
import jdbc.connection.ConnectionProvider;

public class ListArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private int size = 10;

	public ArticlePage getArticlePage(int pageNum) throws ClassNotFoundException {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = articleDao.selectCount(conn);
			List<Article2> content = articleDao.select(
					conn, (pageNum - 1) * size, size);
			return new ArticlePage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
