package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvjsp.jdbc.JdbcUtil;
import product.model.Cart;
import product.model.CartList;
import product.model.ProductContent;

public class CartDao {
		public CartList readDB(Connection conn,Cart cart) throws SQLException{
			CartList cartList = new CartList();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				int itemNum = cart.getSize();
				for(int cnt=0; cnt < itemNum; cnt++){
					String code = cart.getCode(cnt);
					int number = cart.getNumber(cnt);
					pstmt = conn.prepareStatement("select name from product " + "where product_no = '" + code + "';");
					pstmt.setInt(1, Integer.parseInt(code));
					rs = pstmt.executeQuery();
					
					//����
					if(!rs.next())
						try {
							throw new Exception("�ش� ��ǰ�� �����ϴ�. [��ǰ�ڵ� : " + code + "]");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					String name = rs.getString("name");
					int price = 100000;	//�����ؾ� �� �κ�
					cartList.setCode(cnt, code);
					cartList.setName(cnt,name);
					cartList.setPrice(cnt, price);
					cartList.setNumber(cnt, number);
					
					return cartList;
				}

			} finally {
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
			}
			return null;
		}
}
