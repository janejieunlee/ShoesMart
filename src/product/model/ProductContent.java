package product.model;

public class ProductContent {
	private Integer number;
	private String content;
	
	public ProductContent(Integer number, String content){
		this.number = number;
		this.content = content;
	}
	
	public Integer getNumber(){
		return number;
	}
	
	public String getContent(){
		return content;
	}
}
