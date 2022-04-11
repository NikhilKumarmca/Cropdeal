package io.cropProject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.cropProject.model.Product;
import io.cropProject.service.Productservice;

@SpringBootTest(classes= {ControllerMokitoTest.class})
public class ControllerMokitoTest {

	@Mock
	Productservice productservice;
	
	@InjectMocks
	ProductController productcontroller;
	
	List<Product> mockProduct;
	
	@Test
	public void getAllProductTest()
	{
		mockProduct = new ArrayList<Product>();
		mockProduct.add(new Product("001","Apple","Fruit",120.0f,"Raipur","002"));
		mockProduct.add(new Product("002","Orange","Fruit",80.0f,"Nagpur","001"));
		
		when(productservice.getAllproduct()).thenReturn(mockProduct);
		ResponseEntity<List<Product>> res = productcontroller.getAllproduct();
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(2, res.getBody().size());
	}
	
	@Test
	public void getProductTest()
	{
		Product mockProduct = new Product("003","Carrot","Vegetable",50.0f,"Patna","002");
		String productid="003";
		
		when(productservice.getProduct(productid)).thenReturn(Optional.of(mockProduct));
		ResponseEntity<Optional<Product>> res = productcontroller.getProduct(productid);
		assertEquals(productid, mockProduct.getProductId());
		assertEquals(HttpStatus.FOUND, res.getStatusCode());
		assertEquals(productid, res.getBody().get().getProductId());
	}
	
	@Test
	public void AddproductTest()
	{
		Product mockProduct = new Product("003","Carrot","Vegetable",50.0f,"Patna","002");
		
		when(productservice.Addproduct(mockProduct)).thenReturn(mockProduct);
		ResponseEntity<Product> res= productcontroller.Addproduct(mockProduct);
		
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(mockProduct, res.getBody());
	}
	
	@Test
	public void updateProductTest()
	{
		Product mockProduct = new Product("003","Carrot","Vegetable",50.0f,"Patna","002");
		String productid="003";
		
		when(productservice.updateProduct(mockProduct, productid)).thenReturn(productid);
		
		ResponseEntity<String> res=productcontroller.updateProduct(mockProduct, productid);
		assertEquals(productid, mockProduct.getProductId());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}
	
	@Test
	public void deleteProductTest()
	{
		Product mockProduct = new Product("003","Carrot","Vegetable",50.0f,"Patna","002");
		String productid="003";
		
		ResponseEntity<String> res= productcontroller.deleteProduct(productid);
		assertEquals(productid, mockProduct.getProductId());
		assertEquals(HttpStatus.OK, res.getStatusCode());
		
	}
	
}

