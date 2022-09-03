package com.proje.model;

import java.util.Date;

public class Product {
	private int productId ;
	
	private String  name;
	private double price;
	
	private int avalible ;
	
	private Date  addDate ;
	public Product() {}
	public Product(int productId, String name, double price, int avalible, Date addDate) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.avalible = avalible;
		this.addDate = addDate;
	}
	
	
	public Product(String name, double price, int avalible, Date addDate) {
	
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.avalible = avalible;
		this.addDate = addDate;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvalible() {
		return avalible;
	}
	public void setAvalible(int avalible) {
		this.avalible = avalible;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	
	

	 
}
