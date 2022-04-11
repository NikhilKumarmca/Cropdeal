package io.cropProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.cropProject.model.Product;
import io.cropProject.repo.ProductRepo;

@Service
public class Productservice {

	@Autowired
	public ProductRepo productrepo;

	public List<Product> getAllproduct() {
		return productrepo.findAll();
		
	}

	public Optional<Product> getProduct(String productid) {
		
		return productrepo.findById(productid);
	}

	public Product Addproduct(Product product) {
		
		return productrepo.save(product);
	}

	public String updateProduct(Product product, String productid) {
		Optional<Product> productData = productrepo.findById(productid);
		if(productData.isPresent())
		{
			Product produ = productData.get();
		    produ.setProductName(product.getProductName());
		    produ.setProductPrice(product.getProductPrice());
		    produ.setProductType(product.getProductType());
		    produ.setLocation(product.getLocation());
		    this.productrepo.save(produ);
		    return "Product detail is updated";
		}
		else
		{
			return "Product detail is not updated";
		}
		
	}

	public String deleteProduct(String productid) {
		productrepo.deleteById(productid);
		return productid+" was deleted successfully";
	}

	public List<Product> getfarmer(String farmeremail) {
		
		return productrepo.findByFarmerEmail(farmeremail);
	}

	
	
	
}
