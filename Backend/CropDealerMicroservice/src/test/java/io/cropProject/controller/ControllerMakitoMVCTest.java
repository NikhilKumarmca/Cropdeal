package io.cropProject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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

import io.cropProject.model.Dealer;
import io.cropProject.service.DealerService;

@ComponentScan(basePackages = "io.cropProject")
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes= {ControllerMakitoMVCTest.class})
class ControllerMakitoMVCTest {

	@Autowired
	MockMvc mockMvc;
	
	@Mock
	DealerService dealerservice;
	
	@InjectMocks
	DealerController dealercontroller;
	
	List<Dealer> mockDealer;
	Dealer dealer;
	
	@BeforeEach
	public void setUp()
	{
		mockMvc = MockMvcBuilders.standaloneSetup(dealercontroller).build();
		
	}
	
	@Test
	void getAllDealerTest() throws Exception
	{
		mockDealer = new ArrayList<Dealer>();
		mockDealer.add(new Dealer("001","Raju kumar","9992231523","Noida","raju@gmail.com","Raju@123","male"));
		mockDealer.add(new Dealer("002","Raj kumar","8762231521","Kolkata","raj@gmail.com","Raj@123","male"));
		
		when(dealerservice.getAlldealer()).thenReturn(mockDealer);
		
		this.mockMvc.perform(get("/dealer/list")).andExpect(status().isFound()).andDo(print());
	}
	
	@Test
	void getDealerbyemailTest() throws Exception
	{
		dealer = new Dealer("003","Raju kumar","9992231523","Noida","raju@gmail.com","Raju@123","male");
		String dealeremail="raju@gmail.com";
		
		when(dealerservice.getDealerbyemail(dealeremail)).thenReturn(dealer);
		assertEquals(dealeremail, dealer.getDealerEmail());
		this.mockMvc.perform(get("/dealer/list/{email}",dealeremail))
					.andExpect(status().isOk())
					.andExpect(MockMvcResultMatchers.jsonPath(".dealerId").value("003"))
					.andExpect(MockMvcResultMatchers.jsonPath(".dealerName").value("Raju kumar"))
					.andExpect(MockMvcResultMatchers.jsonPath(".dealerPhone").value("9992231523"))
					.andExpect(MockMvcResultMatchers.jsonPath(".dealerAddress").value("Noida"))
					.andExpect(MockMvcResultMatchers.jsonPath(".dealerEmail").value("raju@gmail.com"))
					.andExpect(MockMvcResultMatchers.jsonPath(".dealerPassword").value("Raju@123"))
					.andExpect(MockMvcResultMatchers.jsonPath(".dealerGender").value("male"))
					.andDo(print());
		
	}
	
	@Test
	void AddDealerTest() throws Exception
	{
		dealer = new Dealer("004","Raju kumar","9992231523","Noida","raju@gmail.com","Raju@123","male");
		
		when(dealerservice.AddDealer(dealer)).thenReturn(dealer);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonbody = mapper.writeValueAsString(dealer);
		
		this.mockMvc.perform(post("/dealer/list/add")
								.content(jsonbody)
								.contentType(MediaType.APPLICATION_JSON)
							)
				.andExpect(status().isCreated())
				.andDo(print());
		
				
	}
	
//	@Test
//	public void updateDealerTest() throws Exception
//	{
//		dealer = new Dealer("004","Raju kumar","9992231523","Noida","raju@gmail.com","Raju@123","male");
//		String dealerid = "004";
//		
//		when(dealerservice.updateDealer(dealer)).thenReturn(dealerid);
//		assertEquals(dealerid, dealer.getDealerId());
//		ObjectMapper mapper = new ObjectMapper();
//		String jsonbody = mapper.writeValueAsString(dealer);
//		
//		this.mockMvc.perform(put("/dealer/list/{id}",dealerid)
//				.content(jsonbody)
//				.contentType(MediaType.APPLICATION_JSON)
//				)
//			.andExpect(status().isOk())
//			.andDo(print());
//		
//	}
	
	@Test
	void deleteDealerTest() throws Exception
	{
		dealer = new Dealer("004","Raju kumar","9992231523","Noida","raju@gmail.com","Raju@123","male");
		String dealerid = "004";
		
		when(dealerservice.deleteDealer(dealerid)).thenReturn(dealerid);
		assertEquals(dealerid, dealer.getDealerId());
		this.mockMvc.perform(delete("/dealer/list/{id}",dealerid))
					.andExpect(status().isOk());
		
	}

}
