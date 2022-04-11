package io.cropProject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import io.cropProject.classes.Product;
import io.cropProject.model.Farmer;
import io.cropProject.service.FarmerService;

@SpringBootTest(classes= {ControllerTest.class})
class ControllerTest {
	@Mock
	FarmerService farmerservice;
	
	@InjectMocks
	FarmerController farmercontroller;
	
	List<Farmer> mockFarmer;
	List<Product> mockProduct;
	Farmer farmer;
	@Mock
	RestTemplate resttemplate;
	
	@Test
	void getAllFarmerTest()
	{
		 mockProduct = new ArrayList<Product>();
		 mockFarmer = new ArrayList<Farmer>();
		 mockFarmer.add(new Farmer("001", "Ravi kumar","Male","9911223312","ravi@gmail.com","Ravi@123","Patna",mockProduct));		 
		 mockProduct.add(new Product("001","Apple","Fruit",120.0f,"Raipur","002"));
		 mockProduct.add(new Product("002","Orange","Fruit",80.0f,"Nagpur","001"));
		 
		 when(farmerservice.getAllFarmer()).thenReturn(mockFarmer);
		 ResponseEntity<List<Farmer>> res=farmercontroller.getAllFarmer();
		 
		 assertEquals(HttpStatus.OK,res.getStatusCode());
		 assertEquals(1,res.getBody().size());
		 
		
	}
	
	@Test
	void getFarmerdetails()
	{
		mockProduct = new ArrayList<Product>();
		 farmer = new Farmer("001", "Ravi kumar","Male","9911223312","ravi@gmail.com","Ravi@123","Patna",mockProduct);
		 mockProduct.add(new Product("001","Apple","Fruit",120.0f,"Raipur","002"));
		 mockProduct.add(new Product("002","Orange","Fruit",80.0f,"Nagpur","001"));
		 String farmeremail="ravi@gmail.com";
		 when(farmerservice.getFarmerdetails(farmeremail)).thenReturn(farmer);
		 
		 ResponseEntity<Farmer> res=farmercontroller.getFarmerdetails(farmeremail);
		 assertEquals(farmeremail, farmer.getFarmerEmail());
		 assertEquals(HttpStatus.OK, res.getStatusCode());
		 assertEquals(farmeremail, res.getBody().getFarmerEmail());
		
	}
	
	@Test
	void AddFarmer()
	{
		mockProduct = new ArrayList<Product>();
		 farmer = new Farmer("001", "Ravi kumar","Male","9911223312","ravi@gmail.com","Ravi@123","Patna",mockProduct);
		 mockProduct.add(new Product("001","Apple","Fruit",120.0f,"Raipur","002"));
		 mockProduct.add(new Product("002","Orange","Fruit",80.0f,"Nagpur","001"));
		 
		 when(farmerservice.AddFarmer(farmer)).thenReturn(farmer);
		 ResponseEntity<Farmer> res=farmercontroller.AddFarmer(farmer);
		 
		 assertEquals(HttpStatus.CREATED, res.getStatusCode());
		 assertEquals(farmer, res.getBody());
	}
	
	@Test
	void deleteDealer()
	{
		mockProduct = new ArrayList<Product>();
		 farmer = new Farmer("001", "Ravi kumar","Male","9911223312","ravi@gmail.com","Ravi@123","Patna",mockProduct);
		 mockProduct.add(new Product("001","Apple","Fruit",120.0f,"Raipur","002"));
		 mockProduct.add(new Product("002","Orange","Fruit",80.0f,"Nagpur","001"));
		 String farmeremail="ravi@gmail.com";
		 
		 ResponseEntity<String> res=farmercontroller.deleteFarmer(farmeremail);
		 assertEquals(farmeremail, farmer.getFarmerEmail());
		 assertEquals(HttpStatus.OK, res.getStatusCode());
	}
	
	@Test
	void getFarmerproduct()
	{
		mockProduct = new ArrayList<Product>();
		 farmer = new Farmer("001", "Ravi kumar","Male","9911223312","ravi@gmail.com","Ravi@123","Patna",mockProduct);
		 mockProduct.add(new Product("001","Apple","Fruit",120.0f,"Raipur","002"));
		 mockProduct.add(new Product("002","Orange","Fruit",80.0f,"Nagpur","001"));
		 String farmeremail = "ravi@gmail.com";
		 
		 
		 when(farmerservice.getFarmerdetails(farmeremail)).thenReturn(farmer);
		 when(resttemplate.getForObject("http://product-service/product/farmer/"+farmer.getFarmerEmail(), List.class)).thenReturn(mockProduct);	
		 
		 ResponseEntity<Farmer> res=farmercontroller.getFarmerproduct(farmeremail);
		 assertEquals(mockProduct, res.getBody().getProductList());
		 
		 
	}
	
	@Test
	void updateFarmer()
	{
		mockProduct = new ArrayList<Product>();
		 farmer = new Farmer("001", "Ravi kumar","Male","9911223312","ravi@gmail.com","Ravi@123","Patna",mockProduct);
		 mockProduct.add(new Product("001","Apple","Fruit",120.0f,"Raipur","002"));
		 mockProduct.add(new Product("002","Orange","Fruit",80.0f,"Nagpur","001"));
		String farmeremail="ravi@gmail.com";
		
		when(farmerservice.getFarmerdetails(farmeremail)).thenReturn(farmer);
		when(farmerservice.updateFarmer(farmer)).thenReturn(farmer);
		assertEquals(farmeremail, farmer.getFarmerEmail());
		ResponseEntity<Farmer> res=farmercontroller.updateFarmer(farmer, farmeremail);
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals("001", res.getBody().getFarmerId());
		assertEquals("ravi@gmail.com", res.getBody().getFarmerEmail());
		assertEquals("Ravi kumar", res.getBody().getFarmerName());
		assertEquals("9911223312", res.getBody().getFarmerPhone());
		assertEquals("Patna", res.getBody().getFarmerAddress());
		assertEquals("Ravi@123", res.getBody().getFarmerPassword());
		assertEquals("Male", res.getBody().getFarmerGender());

	}
	
	@Test
	void getLogin()
	{
		mockProduct = new ArrayList<Product>();
		 farmer = new Farmer("001", "Ravi kumar","Male","9911223312","ravi@gmail.com","Ravi@123","Patna",mockProduct);
		 mockProduct.add(new Product("001","Apple","Fruit",120.0f,"Raipur","002"));
		 mockProduct.add(new Product("002","Orange","Fruit",80.0f,"Nagpur","001"));
		String farmeremail = "ravi@gmail.com";
		String farmerpassword = "Ravi@123";
		
		when(farmerservice.getLogin(farmeremail, farmerpassword)).thenReturn(farmer);
		ResponseEntity<Farmer> res = farmercontroller.getLogin(farmer);
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

}
