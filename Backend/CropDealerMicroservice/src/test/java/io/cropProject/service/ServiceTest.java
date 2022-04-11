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

import io.cropProject.model.Dealer;
import io.cropProject.model.Productorder;
import io.cropProject.repo.DealerRepo;
import io.cropProject.repo.Productorderrepo;

@SpringBootTest(classes= {ServiceTest.class})
class ServiceTest {

	@Mock
	DealerRepo dealerrepo;
	
	@Mock
	Productorderrepo orderrepo;
	
	@InjectMocks
	DealerService dealerservice;
	
	public List<Dealer> mockDealer;
	public List<Productorder> mockOrder;
	
	@Test
	void alldealerTest()
	{
		mockDealer = new ArrayList<>();
		mockDealer.add(new Dealer("001","Raju kumar","9992231523","Noida","raju@gmail.com","Raju@123","male"));
		mockDealer.add(new Dealer("002","Raj kumar","8762231521","Kolkata","raj@gmail.com","Raj@123","male"));
		
		
		
		when(dealerrepo.findAll()).thenReturn(mockDealer);
		assertEquals(2, dealerservice.getAlldealer().size());
	}
	
	@Test
	void getDealerbyemailTest()
	{
		Dealer mockDealer = new Dealer("003","Raju kumar","9992231523","Noida","raju@gmail.com","Raju@123","male");
		String dealeremail="raju@gmail.com";
		
		when(dealerrepo.findByDealerEmail(dealeremail)).thenReturn(mockDealer);
		assertEquals(dealeremail, dealerservice.getDealerbyemail(dealeremail).getDealerEmail());
	}
	
	@Test
	void AddDealer()
	{
		Dealer dealer = new Dealer("003","Raju kumar","9992231523","Noida","raju@gmail.com","Raju@123","male");
		
		when(dealerrepo.save(dealer)).thenReturn(dealer);
		assertEquals(dealer, dealerservice.AddDealer(dealer));
	}
	
	@Test
	void updateDealer()
	{
		Dealer dealer = new Dealer("003","Raju kumar","9992231523","Noida","raju@gmail.com","Raju@123","male");
		
		when(dealerrepo.save(dealer)).thenReturn(dealer);
		assertEquals(dealer, dealerservice.updateDealer(dealer));
	}
	
	@Test
	void deleteDealer()
	{
		Dealer dealer = new Dealer("003","Raju kumar","9992231523","Noida","raju@gmail.com","Raju@123","male");
		String dealerid="003";
		
		when(dealerrepo.findById(dealerid)).thenReturn(Optional.of(dealer));
		assertEquals(dealerid+" was deleted successfully", dealerservice.deleteDealer(dealerid));
		
	}
	
	@Test
	void Ordercreate()
	{
		Productorder order =new Productorder("003","raju@gmail.com","Apple",60,3,180);
		when(orderrepo.save(order)).thenReturn(order);
		assertEquals(order, dealerservice.Ordercreate(order));
	}
	
	@Test
	void getorderbyid() 
	{
		mockOrder = new ArrayList<>();
		mockOrder.add(new Productorder("002","raju@gmail.com","Banana",20,9,180));
		mockOrder.add(new Productorder("003","raju@gmail.com","Apple",60,3,180));
		String dealeremail="raju@gmail.com";
		
		when(orderrepo.findByDealerEmail(dealeremail)).thenReturn(mockOrder);
		assertEquals(2, dealerservice.getorderbyid(dealeremail).size());
		
	}
	
	@Test
	void getLogin()
	{
		Dealer dealer = new Dealer("003","Raju kumar","9992231523","Noida","raju@gmail.com","Raju@123","male");
		String dealeremail = "raju@gmail.com";
		String dealerpasswod = "Raj@123";
		
		when(dealerrepo.findByDealerEmailAndDealerPassword(dealeremail, dealerpasswod)).thenReturn(dealer);
		assertEquals(dealer.getDealerEmail(),dealeremail);
		assertEquals(dealer,dealerservice.getLogin(dealeremail, dealerpasswod));
	}
	
	
	
}
