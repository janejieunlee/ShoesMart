package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import jdbc.JdbcUtil;
import product.model.Product;
import product.model.Writer;

public class ProductDao {
	
	private Timestamp toTimestamp(Date date){
		return new Timestamp(date.getTime());
	}
	
	//선택한 수?
	public int selectCount(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from product");
			if(rs.next()){
				return rs.getInt(1);
			}
			return 0;
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	//상품 목록을 리스트로
	public List<Product> select(Connection conn, int startRow, int size) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			pstmt = conn.prepareStatement("select * from product "+
					"order by product_no desc limit ?, ?");
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			List<Product> result = new ArrayList<>();
			while(rs.next()){
				result.add(convertProduct(rs));
			}
			return result;
		} finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Product convertProduct(ResultSet rs) throws SQLException{
//		System.out.println("rs - product_no : " + rs.getInt("product_no"));
//		System.out.println("rs - writer_id : " + rs.getString("writer_id"));
//		System.out.println("rs - writer_name : " + rs.getString("writer_name"));
//		System.out.println("rs - name : " + rs.getString("name"));
//		System.out.println("rs - regdate : " + rs.getTimestamp("regdate"));
//		System.out.println("rs - moddate : " + rs.getTimestamp("moddate"));
//		System.out.println("rs - read_cnt : " + rs.getInt("read_cnt"));
		
		return new Product(
				rs.getInt("product_no"),
				new Writer(rs.getString("writer_id"), rs.getString("writer_name")),
				rs.getString("name"),
				toDate(rs.getTimestamp("regdate")),
				toDate(rs.getTimestamp("moddate")),
				rs.getInt("read_cnt"));
	}
	
	private Date toDate(Timestamp timestamp){
		return new Date(timestamp.getTime());
	}

	//상품 선택했을 때
	public Product selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(
					"select * from product where product_no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Product product = null;
			if (rs.next()) {
				product = convertProduct(rs);
				System.out.println("product : " + product);
			}
			return product;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	//읽은 수 가 많은 순서대로 글 읽기
	public void increaseReadCount(Connection conn, int no) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"update product set read_cnt = read_cnt + 1 "+
						"where product_no = ?")) {
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}
	
	

}
