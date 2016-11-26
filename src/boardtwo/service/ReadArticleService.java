package boardtwo.service;

import java.sql.Connection;
import java.sql.SQLException;

import boardtwo.dao.ArticleContentDao;
import boardtwo.dao.ArticleDao;
import boardtwo.model.Article2;
import boardtwo.model.ArticleContent;
import boardtwo.service.ArticleContentNotFoundException;
import boardtwo.service.ArticleData;
import boardtwo.service.ArticleNotFoundException;
import jdbc.connection.ConnectionProvider;

public class ReadArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public ArticleData getArticle(int articleNum, boolean increaseReadCount) throws ClassNotFoundException {
		try (Connection conn = ConnectionProvider.getConnection()){
			Article2 article = articleDao.selectById(conn, articleNum);
			if (article == null) {
				throw new ArticleNotFoundException();
			}
			ArticleContent content = contentDao.selectById(conn, articleNum);
			if (content == null) {
				throw new ArticleContentNotFoundException();
			}
			if (increaseReadCount) {
				articleDao.increaseReadCount(conn, articleNum);
			}
			return new ArticleData(article, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	}


