package boardtwo.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import boardtwo.dao.ArticleContentDao;
import boardtwo.dao.ArticleDao;
import boardtwo.model.Article2;
import boardtwo.model.ArticleContent;
import boardtwo.service.WriteRequest;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class WriteArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();

	public Integer write(WriteRequest req) throws ClassNotFoundException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			Article2 article = toArticle(req);
			Article2 savedArticle = articleDao.insert(conn, article);
			if (savedArticle == null) {
				throw new RuntimeException("fail to insert article");
			}
			ArticleContent content = new ArticleContent(
					savedArticle.getNumber(),
					req.getContent());
			ArticleContent savedContent = contentDao.insert(conn, content);
			if (savedContent == null) {
				throw new RuntimeException("fail to insert article_content");
			}

			conn.commit();

			return savedArticle.getNumber();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private Article2 toArticle(WriteRequest req) {
		Date now = new Date();
		return new Article2(null, req.getWriter(), req.getTitle(), now, now, 0);
	}
}
