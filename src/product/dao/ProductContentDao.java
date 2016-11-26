package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvjsp.jdbc.JdbcUtil;
import product.model.ProductContent;

public class ProductContentDao {

	public ProductContent selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from product_content where product_no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			ProductContent content = null;
			if (rs.next()) {
				content = new ProductContent(
						rs.getInt("product_no"), rs.getString("content"));
			}
			return content;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
}
