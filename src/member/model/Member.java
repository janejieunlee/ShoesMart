package member.model;

import java.util.Date;

public class Member {

	private String id;
	private String name;
	private String password;
	private String phone;
	private String address;
	private String email;
	private String money;
	private Date regDate;

	public Member(String id, String name, String password, String phone, String address, String email, String money, Date regDate) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.money = money;
		this.regDate = regDate;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getMoney(){
		return money;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}

	public void changePassword(String newPwd) {
		this.password = newPwd;
	}
	
	public void changeName(String newName) {
		this.name = newName;
	}
	
	public void changePhone(String newPhone){
		this.phone = newPhone;
	}
	
	public void changeAddress(String newAddress){
		this.address = newAddress;
	}
	
	public void changeEmail(String newEmail){
		this.email = newEmail;
	}
	
	public void changeMoney(String newMoney){
		this.money = newMoney;
	}

}
