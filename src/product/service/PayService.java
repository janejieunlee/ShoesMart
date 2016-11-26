package product.service;

import java.sql.Connection;
import java.sql.SQLException;

import mvjsp.jdbc.connection.ConnectionProvider;
import product.dao.PayDao;

public class PayService {
	private PayDao payDao = new PayDao();
	private boolean payResult = false;
	public PayProduct getPayProduct(int money, String user_id) throws ClassNotFoundException{
		try(Connection conn= ConnectionProvider.getConnection()){
			System.out.println("PayService money : " + money);
			System.out.println("PayService user_id : " + user_id);
			
			String userMoney = payDao.selectById(conn, user_id);
			
			int changeMoney = Integer.parseInt(userMoney) - money;
			
			if(changeMoney<0){
				System.out.println("금액 부족");
				payResult =false;
			}else{
				System.out.println("결재 완료");
				payResult = true;
				int result = payDao.update(conn, changeMoney, user_id);
			}
			return null;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public boolean payResultMethod(){
		return payResult;
	}	
}
