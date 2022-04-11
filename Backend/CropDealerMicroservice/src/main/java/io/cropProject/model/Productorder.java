package io.cropProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Productorder {

	@Id
	public String porderId;
	public String dealerEmail;
	public String productName;
	public float productPrice;
	public int productQnt;
	public float totalAmt;
	
	
	public Productorder(String porderId, String dealerEmail, String productName, float productPrice, int productQnt,
			float totalAmt) {
		super();
		this.porderId = porderId;
		this.dealerEmail = dealerEmail;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQnt = productQnt;
		this.totalAmt = totalAmt;
	}
	public Productorder() {
		
	} 
	
	
}
