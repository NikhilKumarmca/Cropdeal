package io.cropProject.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.cropProject.classes.Product;

@Document
public class Farmer {

	@Id
	private String farmerId;
	private String farmerName;
	private String farmerGender;
	private String farmerPhone;
	private String farmerEmail;
	private String farmerPassword;
	private String farmerAddress;
	 List<Product> productList = new ArrayList<>();
	
	public String getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(String farmerId) {
		this.farmerId = farmerId;
	}
	public String getFarmerName() {
		return farmerName;
	}
	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}
	public String getFarmerGender() {
		return farmerGender;
	}
	public void setFarmerGender(String farmerGender) {
		this.farmerGender = farmerGender;
	}
	public String getFarmerPhone() {
		return farmerPhone;
	}
	public void setFarmerPhone(String farmerPhone) {
		this.farmerPhone = farmerPhone;
	}
	public String getFarmerEmail() {
		return farmerEmail;
	}
	public void setFarmerEmail(String farmerEmail) {
		this.farmerEmail = farmerEmail;
	}
	public String getFarmerPassword() {
		return farmerPassword;
	}
	public void setFarmerPassword(String farmerPassword) {
		this.farmerPassword = farmerPassword;
	}
	public String getFarmerAddress() {
		return farmerAddress;
	}
	public void setFarmerAddress(String farmerAddress) {
		this.farmerAddress = farmerAddress;
	}
	
	public Farmer(String farmerId, String farmerName, String farmerGender, String farmerPhone, String farmerEmail,
			String farmerPassword, String farmerAddress, List<Product> productList) {
		super();
		this.farmerId = farmerId;
		this.farmerName = farmerName;
		this.farmerGender = farmerGender;
		this.farmerPhone = farmerPhone;
		this.farmerEmail = farmerEmail;
		this.farmerPassword = farmerPassword;
		this.farmerAddress = farmerAddress;
		this.productList = productList;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public Farmer() {
	}
	
	
	
}
