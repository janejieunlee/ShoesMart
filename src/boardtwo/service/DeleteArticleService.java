package boardtwo.service;

import java.sql.Connection;
import java.sql.SQLException;

import boardtwo.dao.ArticleDao;
import jdbc.connection.ConnectionProvider;

public class DeleteArticleService {
	private ArticleDao articleDao = new ArticleDao();

	public int getArticlePage(int pageNum) throws ClassNotFoundException {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int result = articleDao.delete(conn, pageNum);
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
