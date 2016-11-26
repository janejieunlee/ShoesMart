package product.model;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class CartList {
  private ArrayList<String> codeList = new ArrayList<String>();         // ��ǰ�ڵ�
  private ArrayList<String> nameList = new ArrayList<String>();        // ��ǰ��
  private ArrayList<Integer> priceList = new ArrayList<Integer>();      // ����
  private ArrayList<Integer> numberList = new ArrayList<Integer>();     // ����
  //�Ź߻�����
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
	public int getTotalAmount() {	//�ѱݾ�
	     int total = 0;
	     for (int cnt = 0; cnt < codeList.size(); cnt++)
	         total += priceList.get(cnt) * numberList.get(cnt);
	     return total;
	}
	public int getSize() {        // ��ٱ��� ��Ͽ� �ִ� �׸��� ���� �����ϴ� �޼���
	     return codeList.size();
	}  
  
}

