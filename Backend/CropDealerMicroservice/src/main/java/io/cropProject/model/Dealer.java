package io.cropProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Dealer {

	@Id
	private String dealerId;
	private String dealerName;
	private String dealerPhone;
	private String dealerAddress;
	private String dealerEmail;
	private String dealerPassword;
	private String dealerGender;

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerPhone() {
		return dealerPhone;
	}

	public void setDealerPhone(String dealerPhone) {
		this.dealerPhone = dealerPhone;
	}

	public String getDealerAddress() {
		return dealerAddress;
	}

	public void setDealerAddress(String dealerAddress) {
		this.dealerAddress = dealerAddress;
	}

	public String getDealerEmail() {
		return dealerEmail;
	}

	public void setDealerEmail(String dealerEmail) {
		this.dealerEmail = dealerEmail;
	}

	public String getDealerPassword() {
		return dealerPassword;
	}

	public void setDealerPassword(String dealerPassword) {
		this.dealerPassword = dealerPassword;
	}

	public String getDealerGender() {
		return dealerGender;
	}

	public void setDealerGender(String dealerGender) {
		this.dealerGender = dealerGender;
	}

	public Dealer(String dealerId, String dealerName, String dealerPhone, String dealerAddress, String dealerEmail,
			String dealerPassword, String dealerGender) {
		super();
		this.dealerId = dealerId;
		this.dealerName = dealerName;
		this.dealerPhone = dealerPhone;
		this.dealerAddress = dealerAddress;
		this.dealerEmail = dealerEmail;
		this.dealerPassword = dealerPassword;
		this.dealerGender = dealerGender;
	}
	
	

	@Override
	public String toString() {
		return "Dealer [dealerId=" + dealerId + ", dealerName=" + dealerName + ", dealerPhone=" + dealerPhone
				+ ", dealerAddress=" + dealerAddress + ", dealerEmail=" + dealerEmail + ", dealerPassword="
				+ dealerPassword + ", dealerGender=" + dealerGender + "]";
	} 

	public Dealer() {
		
	}

}
