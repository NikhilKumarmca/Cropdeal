package io.cropProject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import io.cropProject.Repo.FarmerRepo;
import io.cropProject.classes.Product;
import io.cropProject.model.Farmer;

@SpringBootTest(classes = {ServiceTest.class})
class ServiceTest {

	@Mock
	FarmerRepo farmerrepo;
	
	
	@InjectMocks
	FarmerService farmerservice;
	
	public List<Farmer> mockFarmer;
	
	public List<Product> mockProduct;
	@Test
	void getFarmerdetailsTest() {
		 mockProduct = new ArrayList<Product>();
		 Farmer farmer = new Farmer("001", "Ravi kumar","Male","9911223312","ravi@gmail.com","Ravi@123","Patna",mockProduct);
		 mockProduct.add(new Product("001","Apple","Fruit",120.0f,"Raipur","002"));
		 mockProduct.add(new Product("002","Orange","Fruit",80.0f,"Nagpur","001"));
		
		String farmeremail="ravi@gmail.com";
		when(farmerrepo.findByFarmerEmail(farmeremail)).thenReturn(farmer);
		assertEquals(farmeremail, farmerservice.getFarmerdetails(farmeremail).getFarmerEmail());
	}
	
	@Test
	void getFarmerproductTest()
	{
		mockProduct = new ArrayList<Product>();
		 Farmer farmer = new Farmer("001", "Ravi kumar","Male","9911223312","ravi@gmail.com","Ravi@123","Patna",mockProduct);
		 mockProduct.add(new Product("001","Apple","Fruit",120.0f,"Raipur","002"));
		 mockProduct.add(new Product("002","Orange","Fruit",80.0f,"Nagpur","001"));
	}
	
	@Test
	void getAllFarmerTest() {
		 mockProduct = new ArrayList<Product>();
		 mockFarmer = new ArrayList<Farmer>();
		 mockFarmer.add(new Farmer("001", "Ravi kumar","Male","9911223312","ravi@gmail.com","Ravi@123","Patna",mockProduct)) ;
		 mockProduct.add(new Product("001","Apple","Fruit",120.0f,"Raipur","002"));
		 mockProduct.add(new Product("002","Orange","Fruit",80.0f,"Nagpur","001"));
		 
		 when(farmerrepo.findAll()).thenReturn(mockFarmer);
		 assertEquals(1,farmerservice.getAllFarmer().size());
		 
		 
		 
	}
	
	@Test
	void AddFarmerTest()
	{
		mockProduct = new ArrayList<Product>();
		 Farmer farmer = new Farmer("001", "Ravi kumar","Male","9911223312","ravi@gmail.com","Ravi@123","Patna",mockProduct);
		 mockProduct.add(new Product("001","Apple","Fruit",120.0f,"Raipur","002"));
		 mockProduct.add(new Product("002","Orange","Fruit",80.0f,"Nagpur","001"));
		
		when(farmerrepo.save(farmer)).thenReturn(farmer);
		assertEquals(farmer, farmerservice.AddFarmer(farmer));
	}
	
	@Test
	void updateFarmerTest()
	{
		mockProduct = new ArrayList<Product>();
		 Farmer farmer = new Farmer("001", "Ravi kumar","Male","9911223312","ravi@gmail.com","Ravi@123","Patna",mockProduct);
		 mockProduct.add(new Product("001","Apple","Fruit",120.0f,"Raipur","002"));
		 mockProduct.add(new Product("002","Orange","Fruit",80.0f,"Nagpur","001"));
		 when(farmerrepo.save(farmer)).thenReturn(farmer);
			assertEquals(farmer, farmerservice.updateFarmer(farmer));
		
	}
	
	@Test
	void deleteFarmerTest()
	{
		mockProduct = new ArrayList<Product>();
		 Farmer farmer = new Farmer("001", "Ravi kumar","Male","9911223312","ravi@gmail.com","Ravi@123","Patna",mockProduct);
		 mockProduct.add(new Product("001","Apple","Fruit",120.0f,"Raipur","002"));
		 mockProduct.add(new Product("002","Orange","Fruit",80.0f,"Nagpur","001"));
		 String farmerid="001";
		 
		 when(farmerrepo.findById(farmerid)).thenReturn(Optional.of(farmer));
			assertEquals(farmerid+" was deleted successfully", farmerservice.deleteFarmer(farmerid));
		
	}
	
	@Test
	void getLogin()
	{
		mockProduct = new ArrayList<Product>();
		 Farmer farmer = new Farmer("001", "Ravi kumar","Male","9911223312","ravi@gmail.com","Ravi@123","Patna",mockProduct);
		 mockProduct.add(new Product("001","Apple","Fruit",120.0f,"Raipur","002"));
		 mockProduct.add(new Product("002","Orange","Fruit",80.0f,"Nagpur","001"));
		 
		String farmeremail = "ravi@gmail.com";
		String farmerpasswod = "Ravi@123";
		
		when(farmerrepo.findByFarmerEmailAndFarmerPassword(farmeremail, farmerpasswod)).thenReturn(farmer);
		assertEquals(farmer.getFarmerEmail(),farmeremail);
		assertEquals(farmer,farmerservice.getLogin(farmeremail, farmerpasswod));
	}
}
