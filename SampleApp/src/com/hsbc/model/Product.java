package com.hsbc.model;

public class Product {

	String productName;
	int productCode;
	String category;
	int quantity;
	double price;
	int rol;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	public Product( int productCode,String productName, String category, double price, int quantity, int rol) {
		super();
		this.productName = productName;
		this.productCode = productCode;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
		this.rol = rol;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productCode=" + productCode + ", category=" + category
				+ ", quantity=" + quantity + ", price=" + price + ", rol=" + rol + "]";
	}
	
}
