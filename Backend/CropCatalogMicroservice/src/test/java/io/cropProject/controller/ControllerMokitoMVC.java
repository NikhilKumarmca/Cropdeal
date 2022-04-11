package io.cropProject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.cropProject.model.Product;
import io.cropProject.service.Productservice;

@ComponentScan(basePackages = "io.cropProject")
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes= {ControllerMokitoMVC.class})
class ControllerMokitoMVC {

	@Autowired
	MockMvc mockMvc;
	
	@Mock
	Productservice productservice;
	
	@InjectMocks
	ProductController productcontroller;
	
	List<Product> mockProduct;
	Product product;
	
	@BeforeEach
	public void setUp()
	{
		mockMvc = MockMvcBuilders.standaloneSetup(productcontroller).build();
		
	}
	
	@Test
	void getAllProductTest() throws Exception
	{
	
		mockProduct = new ArrayList<Product>();
		mockProduct.add(new Product("001","Apple","Fruit",120.0f,"Raipur","002"));
		mockProduct.add(new Product("002","Orange","Fruit",80.0f,"Nagpur","001"));
		
		when(productservice.getAllproduct()).thenReturn(mockProduct);
		
		this.mockMvc.perform(get("/product/list")).andExpect(status().isOk()).andDo(print());
	}
	
	@Test
	void getProductTest() throws Exception
	{
		product = new Product("003","Carrot","Vegetable",50.0f,"Patna","raju@gmail.com");
		String productid="003";
		
		when(productservice.getProduct(productid)).thenReturn(Optional.of(product));
		assertEquals(productid, product.getProductId());
		this.mockMvc.perform(get("/product/list/{id}",productid))
					.andExpect(status().isFound())
					.andExpect(MockMvcResultMatchers.jsonPath(".productId").value("003"))
					.andExpect(MockMvcResultMatchers.jsonPath(".productName").value("Carrot"))
					.andExpect(MockMvcResultMatchers.jsonPath(".productType").value("Vegetable"))
					.andExpect(MockMvcResultMatchers.jsonPath(".productPrice").value(50.0))
					.andExpect(MockMvcResultMatchers.jsonPath(".location").value("Patna"))
					.andExpect(MockMvcResultMatchers.jsonPath(".farmerEmail").value("raju@gmail.com"))
					.andDo(print());
		
		
	}
	
	@Test
	void AddproductTest() throws Exception
	{
		product = new Product("003","Carrot","Vegetable",50.0f,"Patna","002");
		
		when(productservice.Addproduct(product)).thenReturn(product);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonbody = mapper.writeValueAsString(product);
		
		this.mockMvc.perform(post("/product/list/add")
								.content(jsonbody)
								.contentType(MediaType.APPLICATION_JSON)
							)
				.andExpect(status().isCreated())
				.andDo(print());
		
				
	}
	
	@Test
	void updateProductTest() throws Exception
	{
		product = new Product("003","Carrot","Vegetable",50.0f,"Patna","002");
		String productid="003";
		
		when(productservice.updateProduct(product, productid)).thenReturn(productid);
		assertEquals(productid, product.getProductId());
		ObjectMapper mapper = new ObjectMapper();
		String jsonbody = mapper.writeValueAsString(product);
		
		this.mockMvc.perform(put("/product/list/{id}",productid)
				.content(jsonbody)
				.contentType(MediaType.APPLICATION_JSON)
				)
			.andExpect(status().isOk())
			.andDo(print());
		
	}
	
	@Test
	void deleteProductTest() throws Exception
	{
		product = new Product("003","Carrot","Vegetable",50.0f,"Patna","002");
		String productid="003";
		
		when(productservice.deleteProduct(productid)).thenReturn(productid);
		assertEquals(productid, product.getProductId());
		this.mockMvc.perform(delete("/product/list/{id}",productid))
					.andExpect(status().isOk());
		
	}
}
