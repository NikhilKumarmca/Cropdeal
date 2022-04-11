package io.cropProject.classes;

public class Product {

	private String productId;
	private String productName;
	private String productType;
	private float productPrice;
	private String location;
	private String farmerId;

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

	public String getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(String farmerId) {
		this.farmerId = farmerId;
	}

	public Product(String productId, String productName, String productType, float productPrice, String location,
			String farmerId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.productPrice = productPrice;
		this.location = location;
		this.farmerId = farmerId;
	}

	public Product() {
		super();
	}

}
