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

import io.cropProject.model.Dealer;
import io.cropProject.model.Productorder;
import io.cropProject.service.DealerService;

@SpringBootTest(classes= {ControllerMakitoTest.class})
class ControllerMakitoTest {

	@Mock
	DealerService dealerservice;
	
	@InjectMocks
	DealerController dealercontroller;
	
	List<Dealer> mockDealer;
	Dealer dealer;
	
	List<Productorder> MockOrder;
	List<Productorder> mockOrder;
	Productorder order;
	
	
	
	@Test
	void getAllDealerTest()
	{
		mockDealer = new ArrayList<Dealer>();
		mockDealer.add(new Dealer("001","Raju kumar","9992231523","Noida","raju@gmail.com","Raju@123","male"));
		mockDealer.add(new Dealer("002","Raj kumar","8762231521","Kolkata","raj@gmail.com","Raj@123","male"));
		
		when(dealerservice.getAlldealer()).thenReturn(mockDealer);
		ResponseEntity<List<Dealer>> res=dealercontroller.getAllDealer();
		
		assertEquals(HttpStatus.FOUND, res.getStatusCode());
		assertEquals(2,res.getBody().size());
	}
	
	@Test
	void getDealerbyemailTest()
	{
		dealer = new Dealer("003","Raju kumar","9992231523","Noida","raju@gmail.com","Raju@123","male");
		String dealeremail="raju@gmail.com";
		
		when(dealerservice.getDealerbyemail(dealeremail)).thenReturn(dealer);
	
		ResponseEntity<Dealer> res= dealercontroller.getDealerbyemail(dealeremail);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(dealer, res.getBody());
		
	}
	
	@Test
	void AddDealer()
	{
		dealer = new Dealer("003","Raju kumar","9992231523","Noida","raju@gmail.com","Raju@123","male");
		
		when(dealerservice.AddDealer(dealer)).thenReturn(dealer);
		ResponseEntity<Dealer> res=dealercontroller.AddDealer(dealer);
		
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(dealer, res.getBody());
	}
	
	@Test
	void updateDealer()
	{
		dealer = new Dealer("003","Ram kumar","9992231523","Gujrat","ram@gmail.com","Ram@123","male");
		String dealeremail="ram@gmail.com";
		
		when(dealerservice.getDealerbyemail(dealeremail)).thenReturn(dealer);
		when(dealerservice.updateDealer(dealer)).thenReturn(dealer);
		assertEquals(dealeremail, dealer.getDealerEmail());
		ResponseEntity<Dealer> res=dealercontroller.updateDealer(dealer, dealeremail);
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals("003", res.getBody().getDealerId());
		assertEquals("ram@gmail.com", res.getBody().getDealerEmail());
		assertEquals("Ram kumar", res.getBody().getDealerName());
		assertEquals("9992231523", res.getBody().getDealerPhone());
		assertEquals("Gujrat", res.getBody().getDealerAddress());
		assertEquals("Ram@123", res.getBody().getDealerPassword());
		assertEquals("male", res.getBody().getDealerGender());

	}
	
	
	@Test
	void deleteDealer()
	{
		dealer = new Dealer("003","Ram kumar","9992231523","Gujrat","ram@gmail.com","Ram@123","male");
		String dealerid="003";
		
		ResponseEntity<String> res=dealercontroller.deleteDealer(dealerid);
		assertEquals(dealerid, dealer.getDealerId());
		assertEquals(HttpStatus.OK, res.getStatusCode());
		
	}
	
	@Test
	void getLoginTest()
	{
		dealer = new Dealer("003","Ram kumar","9992231523","Gujrat","ram@gmail.com","Ram@123","male");
		
		String dealeremail = dealer.getDealerEmail();
		String dealerpassword = dealer.getDealerPassword();
		
		when(dealerservice.getLogin(dealeremail, dealerpassword)).thenReturn(dealer);
		ResponseEntity<Dealer> res = dealercontroller.getLogin(dealer);
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}
	
	@Test
	void OrdercreateTest()
	{
		Productorder order =new Productorder("003","raju@gmail.com","Apple",60,3,180);
		
		when(dealerservice.Ordercreate(order)).thenReturn(order);
		ResponseEntity<Productorder> res=dealercontroller.Ordercreate(order);
		
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(order, res.getBody());
		
	}
	
	@Test
	void getorderbyid()
	{
		mockOrder = new ArrayList<>();
		mockOrder.add(new Productorder("002","raju@gmail.com","Banana",20,9,180));
		mockOrder.add(new Productorder("003","raju@gmail.com","Apple",60,3,180));
		String dealeremail = "raju@gmail.com";
		when(dealerservice.getorderbyid(dealeremail)).thenReturn(mockOrder);
		ResponseEntity<List<Productorder>> res=dealercontroller.getorderbyid(dealeremail);
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(2,res.getBody().size());
		
	}
	
	
	
}
