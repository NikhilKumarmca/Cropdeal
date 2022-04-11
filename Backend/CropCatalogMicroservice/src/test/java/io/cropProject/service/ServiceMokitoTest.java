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

import io.cropProject.model.Product;
import io.cropProject.repo.ProductRepo;

@SpringBootTest(classes= {ServiceMokitoTest.class})
public class ServiceMokitoTest {
	
	@Mock
	ProductRepo productrepo;
	
	@InjectMocks
	Productservice productservice;
	
	public List<Product> mockProduct;
	
	@Test
	public void getAllproductTest()
	{
		List<Product> mockProduct = new ArrayList<Product>();
		mockProduct.add(new Product("001","Apple","Fruit",120.0f,"Raipur","002"));
		mockProduct.add(new Product("002","Orange","Fruit",80.0f,"Nagpur","001"));
		
		
		
		when(productrepo.findAll()).thenReturn(mockProduct);
		assertEquals(2, productservice.getAllproduct().size());
	}
	

	@Test
	public void getProductTest()
	{
		Product mockProduct = new Product("003","Carrot","Vegetable",50.0f,"Patna","002");
		String productid="003";
		
		when(productrepo.findById(productid)).thenReturn(Optional.of(mockProduct));
		assertEquals(productid, productservice.getProduct(productid).get().getProductId());
	}
	
	@Test
	public void AddproductTest()
	{
		Product mockProduct = new Product("003","Carrot","Vegetable",50.0f,"Patna","002");
		
		when(productrepo.save(mockProduct)).thenReturn(mockProduct);
		assertEquals(mockProduct, productservice.Addproduct(mockProduct));
	}
	
	@Test
	public void updateProductTest()
	{
		Product mockProduct = new Product("003","Carrot","Vegetable",50.0f,"Patna","002");
		String productid = "003";
		
		when(productrepo.findById(productid)).thenReturn(Optional.of(mockProduct));
		assertEquals("Product detail is updated", productservice.updateProduct(mockProduct, productid));
	}
	
	@Test
	public void deleteProductTest()
	{
		Product mockProduct = new Product("003","Carrot","Vegetable",50.0f,"Patna","002");
		String productid = "003";
		
		when(productrepo.findById(productid)).thenReturn(Optional.of(mockProduct));
		assertEquals(productid+" was deleted successfully", productservice.deleteProduct(productid));
		
	}
	
}
