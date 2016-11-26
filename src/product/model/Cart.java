package product.model;

import java.util.LinkedList;

public class Cart {
	private LinkedList<String> codeList = new LinkedList<String>();        // ��ǰ�ڵ�
	private LinkedList<Integer> numberList = new LinkedList<Integer>();    // ����
	//
	private LinkedList<String> nameList = new LinkedList<String>();
	private LinkedList<String> priceList = new LinkedList<String>();
	//
	
	public void addItem(String code, int num, String name, String price) {                // ��ٱ��Ͽ� ��ǰ ������ �߰��ϴ� �޼���
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
	
	public String getCode(int index){	//��ǰ ��ȣ
		return codeList.get(index);
	}
	public int getNumber(int index){	//��ǰ ����
		return numberList.get(index);
	}
	
	//
	public String getName(int index){	//��ǰ��
		return nameList.get(index);		
	}
	public String getPrice(int index){	//��ǰ ����
		return priceList.get(index);
	}
	
	//
	public int getSize(){	// ��ٱ��Ͽ� �ִ� �׸��� ���� �����ϴ� �޼���
		return codeList.size();
	}
	
	//�����
}
