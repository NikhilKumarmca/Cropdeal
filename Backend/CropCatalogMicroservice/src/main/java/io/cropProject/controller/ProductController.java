package io.cropProject.controller;

import java.util.List;
import java.util.Optional;

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

import io.cropProject.model.Product;
import io.cropProject.service.Productservice;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@RestController
@OpenAPIDefinition
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

	@Autowired
	public Productservice productservice;
	
	@GetMapping("/list")
	public ResponseEntity<List<Product>>  getAllproduct()
	{
		try {
			return new ResponseEntity<>(productservice.getAllproduct(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<Optional<Product>> getProduct(@PathVariable("id") String productid)
	{
		try {
			return new ResponseEntity<>(productservice.getProduct(productid),HttpStatus.FOUND);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping("/farmer/{femail}")
	public ResponseEntity<List<Product>> getfarmer(@PathVariable("femail") String farmeremail)
	{
		try
		{
			return new ResponseEntity<>(productservice.getfarmer(farmeremail),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/list/add")
	public ResponseEntity<Product> Addproduct(@RequestBody Product product)
	{
		try 
		{
			return new ResponseEntity<>(productservice.Addproduct(product),HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
	@PutMapping("/list/{id}")
	public ResponseEntity<String> updateProduct(@RequestBody Product product ,@PathVariable("id") String productid)
	{
		try
		{
			return new ResponseEntity<>(productservice.updateProduct(product,productid),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
	}
	
	@DeleteMapping("/list/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") String productid)
	{
		try
		{
			productservice.deleteProduct(productid);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(productid+" was deleted",HttpStatus.OK);
	}
}
