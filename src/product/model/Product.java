package product.model;

import java.util.Date;

public class Product {
	private Integer number; // 상품 번호
	private Writer writer; //관리자
	private String name; //상품 이름
	private Date regDate; //상품 등록된 날짜
	private Date modifiedDate; // 상품 수정된 날짜
	private int readCount; //상품을 읽은 수
	
	public Product(Integer number, Writer writer, String name,
			Date regDate, Date modifiedDate, int readCount){
		this.number = number;
		this.writer = writer;
		this.name = name;
		this.regDate = regDate;
		this.modifiedDate = modifiedDate;
		this.readCount = readCount;
	}
	
	
	
	public Integer getNumber() {
		return number;
	}
	public Writer getWriter() {
		return writer;
	}
	public String getName() {
		return name;
	}
	public Date getRegDate() {
		return regDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public int getReadCount() {
		return readCount;
	}
	
	
	
	
	
}
