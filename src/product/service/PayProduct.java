package product.service;

public class PayProduct {
	private int money;
	
	public int getMoney(){
		return money;
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	
	public PayProduct(int money){
		this.money = money;
	}
}
