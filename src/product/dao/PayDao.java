package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.JdbcUtil;

public class PayDao {
	
	public String selectById(Connection conn, String user_id) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String userMoney = "";
		try{
			pstmt = conn.prepareStatement("select * from member where memberid = ?");
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				userMoney = rs.getString("money");
			}
					
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}		
		return userMoney;
	}
	

	public int update(Connection conn, int money, String user_id) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.println("update money : " + money);
		System.out.println("update user_id : " + user_id);
		try {
			stmt = conn.createStatement();
			int result = stmt.executeUpdate("update member set money='"+money+"' where memberid='"+user_id+"';");
			return 0;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}		
	}
}
