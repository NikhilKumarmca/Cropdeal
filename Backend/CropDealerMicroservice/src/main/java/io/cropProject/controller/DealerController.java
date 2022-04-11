package io.cropProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.cropProject.model.Dealer;
import io.cropProject.model.Productorder;
import io.cropProject.repo.DealerRepo;
import io.cropProject.service.DealerService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
@CrossOrigin
@RestController
@OpenAPIDefinition
@RequestMapping("/dealer")
public class DealerController {

	@Autowired
	public DealerService dealerservice;
	
	
	@Autowired
	public DealerRepo dealerrepo;
	
	@GetMapping("/list")
	public ResponseEntity<List<Dealer>> getAllDealer()
	{
		try {
			List<Dealer> dealer = dealerservice.getAlldealer();
			return new ResponseEntity<>(dealer,HttpStatus.FOUND);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	@GetMapping("/list/{email}")
	public ResponseEntity<Dealer> getDealerbyemail(@PathVariable("email") String dealeremail)
	{
		try {
			return new ResponseEntity<Dealer>(dealerservice.getDealerbyemail(dealeremail),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	

	
	
	@PostMapping("/login")
	public ResponseEntity<Dealer> getLogin(@RequestBody Dealer dealer)
	{
		String dealerEmail = dealer.getDealerEmail();
		String dealerPassword = dealer.getDealerPassword();
		try {
			Dealer dealerObj = null;
			if(dealerEmail != null && dealerPassword != null)
			{
				dealerObj = dealerservice.getLogin(dealerEmail,dealerPassword);
			}
			return new ResponseEntity<>(dealerObj,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}	
	}
	

	
	@PostMapping("/list/add")
	public ResponseEntity<Dealer> AddDealer(@RequestBody Dealer dealer)
	{
		try {
			return new ResponseEntity<>(dealerservice.AddDealer(dealer),HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
	@PostMapping("/order/create")
	public ResponseEntity<Productorder> Ordercreate(@RequestBody Productorder order)
	{
		try {
			return new ResponseEntity<>(dealerservice.Ordercreate(order),HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
	
	@GetMapping("/order/{email}")
	public ResponseEntity<List<Productorder>> getorderbyid(@PathVariable("email") String dealeremail)
	{
		try {
			return new ResponseEntity<>(dealerservice.getorderbyid(dealeremail),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	@PutMapping("/list/{email}")
	public ResponseEntity<Dealer> updateDealer(@RequestBody Dealer dealer ,@PathVariable("email") String dealeremail)
	{
		try 
		{
			Dealer existdealer = dealerservice.getDealerbyemail(dealeremail);
			existdealer.setDealerName(dealer.getDealerName()); 
		    existdealer.setDealerPhone(dealer.getDealerPhone());
		    existdealer.setDealerAddress(dealer.getDealerAddress());
		    existdealer.setDealerEmail(dealer.getDealerEmail());
		    existdealer.setDealerPassword(dealer.getDealerPassword());
		    existdealer.setDealerGender(dealer.getDealerGender());
			Dealer updated_dealer = dealerservice.updateDealer(existdealer);
			return new ResponseEntity<>(updated_dealer,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/list/{id}")
	public ResponseEntity<String> deleteDealer(@PathVariable("id") String dealerid)
	{
		try {
			dealerservice.deleteDealer(dealerid);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
		}
		return new ResponseEntity<>(dealerid+" was deleted",HttpStatus.OK);
		
		
	}
}
