package product.model;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class CartList {
  private ArrayList<String> codeList = new ArrayList<String>();         // 상품코드
  private ArrayList<String> nameList = new ArrayList<String>();        // 상품명
  private ArrayList<Integer> priceList = new ArrayList<Integer>();      // 가격
  private ArrayList<Integer> numberList = new ArrayList<Integer>();     // 수량
  //신발사이즈
	public CartList() {
	}
	public void setCode(int index, String code) {
	    this.codeList.add(index, code);
	}
	public void setName(int index, String name) {
	    this.nameList.add(index, name);
	}
	public void setPrice(int index, Integer price) {
	    this.priceList.add(index, price);
	}
	public void setNumber(int index, Integer number) {
	    this.numberList.add(index, number);
	}
	public String[] getCode() {
	     return codeList.toArray(new String[codeList.size()]);
	}
	public String[] getName() {
	     return nameList.toArray(new String[nameList.size()]);
	}
	public Integer[] getPrice() {
	     return priceList.toArray(new Integer[priceList.size()]);
	}
	public Integer[] getNumber() {
	     return numberList.toArray(new Integer[numberList.size()]);
	}
	public int getTotalAmount() {	//총금액
	     int total = 0;
	     for (int cnt = 0; cnt < codeList.size(); cnt++)
	         total += priceList.get(cnt) * numberList.get(cnt);
	     return total;
	}
	public int getSize() {        // 장바구니 목록에 있는 항목의 수를 리턴하는 메서드
	     return codeList.size();
	}  
  
}

