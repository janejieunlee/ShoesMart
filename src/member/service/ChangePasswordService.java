package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class ChangePasswordService {
	
	private MemberDao memberDao = new MemberDao();
	
	public void charngePassword(String userId, String curPwd, String newPwd, String newPhone, String newName, String newAddress, String newEmail, String newMoney){
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, userId);
			if(member == null){
				throw new MemberNotFoundException();
			}
			if(!member.matchPassword(curPwd)){
				throw new InvalidPasswordException();
			}
			member.changePassword(newPwd);
			member.changeName(newName);
			member.changePhone(newPhone);
			member.changeAddress(newAddress);
			member.changeEmail(newEmail);
			member.changeMoney(newMoney);
			memberDao.update(conn, member);
			conn.commit();
		}catch(SQLException e){
			JdbcUtil.rollback(conn);
			throw new RuntimeException();
		}finally{
			JdbcUtil.close(conn);
		}
	}
}
