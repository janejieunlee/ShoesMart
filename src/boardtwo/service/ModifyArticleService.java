package boardtwo.service;

import java.sql.Connection;
import java.sql.SQLException;

import boardtwo.dao.ArticleContentDao;
import boardtwo.dao.ArticleDao;
import boardtwo.model.Article2;
import boardtwo.service.ArticleNotFoundException;
import boardtwo.service.ModifyRequest;
import boardtwo.service.PermissionDeniedException;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class ModifyArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();

	public void modify(ModifyRequest modReq) throws ClassNotFoundException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Article2 article = articleDao.selectById(conn, 
					modReq.getArticleNumber());
			if (article == null) {
				throw new ArticleNotFoundException();
			}
			if (!canModify(modReq.getUserId(), article)) {
				throw new PermissionDeniedException();
			}
			articleDao.update(conn, 
					modReq.getArticleNumber(), modReq.getTitle());
			contentDao.update(conn, 
					modReq.getArticleNumber(), modReq.getContent());
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private boolean canModify(String modfyingUserId, Article2 article) {
		return article.getWriter().getId().equals(modfyingUserId);
	}

}
