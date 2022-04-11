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
import org.springframework.web.client.RestTemplate;

import io.cropProject.Repo.FarmerRepo;
import io.cropProject.model.Farmer;
import io.cropProject.service.FarmerService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition 
@CrossOrigin
@RestController
@RequestMapping("/farmer")
public class FarmerController {

	@Autowired
	public FarmerService farmerservice;
	
	@Autowired
	public FarmerRepo farmerrepo;
	
	@Autowired
	public RestTemplate resttemplate;
	
	@GetMapping("/list")
	public ResponseEntity<List<Farmer>> getAllFarmer()
	{
		try {
			return new ResponseEntity<>(farmerservice.getAllFarmer(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/list/{email}")
	public ResponseEntity<Farmer> getFarmerproduct(@PathVariable("email") String farmeremail)
	{
		try
		{
			Farmer farmer = this.farmerservice.getFarmerdetails(farmeremail);
			@SuppressWarnings("rawtypes")
			List productlist =  this.resttemplate.getForObject("http://product-service/product/farmer/"+farmer.getFarmerEmail(), List.class);
			farmer.setProductList(productlist);
			return new ResponseEntity<>(farmer,HttpStatus.OK);
		}
		catch(Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@GetMapping("farmer/{email}")
	public ResponseEntity<Farmer> getFarmerdetails(@PathVariable("email") String farmeremail)
	{
		try {
			Farmer farmer = this.farmerservice.getFarmerdetails(farmeremail);
			return new ResponseEntity<>(farmer,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/farmer/add")
	public ResponseEntity<Farmer> AddFarmer(@RequestBody Farmer farmer)
	{
		try {
			return new ResponseEntity<>(farmerservice.AddFarmer(farmer),HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	
	
	
	@PutMapping("/list/{email}")
	public ResponseEntity<Farmer> updateFarmer(@RequestBody Farmer farmer ,@PathVariable("email") String farmeremail)
	{
		try {
			Farmer existfarmer = farmerservice.getFarmerdetails(farmeremail);
			existfarmer.setFarmerName(farmer.getFarmerName());
			existfarmer.setFarmerPhone(farmer.getFarmerPhone());
			existfarmer.setFarmerAddress(farmer.getFarmerAddress());
			existfarmer.setFarmerEmail(farmer.getFarmerEmail());
			existfarmer.setFarmerGender(farmer.getFarmerGender());
			existfarmer.setFarmerPassword(farmer.getFarmerPassword());
			Farmer updated_farmer = farmerservice.updateFarmer(farmer);
			return new ResponseEntity<>(updated_farmer,HttpStatus.OK);
		} 
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		
		}
	}
	
	@DeleteMapping("/list/{email}")
	public ResponseEntity<String> deleteFarmer(@PathVariable("email") String farmeremail)
	{
		try {
			return new ResponseEntity<>(farmerservice.deleteFarmer(farmeremail),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
		}
		
	}
	
	@PostMapping("/farmerlogin")
	public ResponseEntity<Farmer> getLogin(@RequestBody Farmer farmer)
	{
		String farmerEmail = farmer.getFarmerEmail();
		String farmerPassword = farmer.getFarmerPassword();
		try {
			Farmer farmerObj = null;
			if(farmerEmail != null && farmerPassword != null)
			{
				farmerObj = farmerservice.getLogin(farmerEmail,farmerPassword);
			}
			return new ResponseEntity<>(farmerObj,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
	
	
}
