package product.model;

import java.util.Date;

public class Product {
	private Integer number; // ��ǰ ��ȣ
	private Writer writer; //������
	private String name; //��ǰ �̸�
	private Date regDate; //��ǰ ��ϵ� ��¥
	private Date modifiedDate; // ��ǰ ������ ��¥
	private int readCount; //��ǰ�� ���� ��
	
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
