package com.proje.model;

public class Product {
	private int productId ;
	private String price;
	private String  name;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String price, String name) {
		super();
		this.productId = productId;
		this.price = price;
		this.name = name;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	 
}
