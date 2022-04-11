package io.cropProject.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	@Id
	private String productId;
	private String productName;
	private String productType;
	private float productPrice;
	private String location;
	private String farmerEmail;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public float getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	public String getFarmerEmail() {
		return farmerEmail;
	}
	public void setFarmerEmail(String farmerEmail) {
		this.farmerEmail = farmerEmail;
	}
	public Product(String productId, String productName, String productType, float productPrice, String location,
			String farmerEmail) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.productPrice = productPrice;
		this.location = location;
		this.farmerEmail = farmerEmail;
	}
	public Product() {
		super();
	}
	
	
}
