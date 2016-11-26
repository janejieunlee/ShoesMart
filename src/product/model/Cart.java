package product.model;

import java.util.LinkedList;

public class Cart {
	private LinkedList<String> codeList = new LinkedList<String>();        // 상품코드
	private LinkedList<Integer> numberList = new LinkedList<Integer>();    // 수량
	//
	private LinkedList<String> nameList = new LinkedList<String>();
	private LinkedList<String> priceList = new LinkedList<String>();
	//
	
	public void addItem(String code, int num, String name, String price) {                // 장바구니에 상품 정보를 추가하는 메서드
		for (int cnt = 0; cnt < codeList.size(); cnt++) {
			 if (codeList.get(cnt).equals(code)) {
				 numberList.set(cnt, numberList.get(cnt) + 1);
				 return;
			 }
		}
		codeList.add(code);
		numberList.add(num);
		nameList.add(name);
		priceList.add(price);
	}
	
	public String getCode(int index){	//상품 번호
		return codeList.get(index);
	}
	public int getNumber(int index){	//상품 수량
		return numberList.get(index);
	}
	
	//
	public String getName(int index){	//상품명
		return nameList.get(index);		
	}
	public String getPrice(int index){	//상품 가격
		return priceList.get(index);
	}
	
	//
	public int getSize(){	// 장바구니에 있는 항목의 수를 리턴하는 메서드
		return codeList.size();
	}
	
	//사이즈도
}
