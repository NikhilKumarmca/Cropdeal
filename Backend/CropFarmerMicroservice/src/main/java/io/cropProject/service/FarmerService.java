package io.cropProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.cropProject.Repo.FarmerRepo;
import io.cropProject.model.Farmer;

@Service
public class FarmerService {

	@Autowired
	public FarmerRepo farmerrepo;
	
	@Autowired
	public RestTemplate resttemplate;
	
	public List<Farmer> getAllFarmer() {
		
		return farmerrepo.findAll();
	}
	
	public Farmer getFarmerdetails(String farmeremail)
	{
		return this.farmerrepo.findByFarmerEmail(farmeremail);
	}

	public Farmer AddFarmer(Farmer farmer) {
		
		return farmerrepo.save(farmer);
	}

	public Farmer updateFarmer(Farmer updated_farmer) {
		
		  return this.farmerrepo.save(updated_farmer);
		
	}

	public String deleteFarmer(String farmerid) {
		farmerrepo.deleteById(farmerid);
		return farmerid+" was deleted successfully";
	}
	
	public Farmer getLogin(String farmerEmail,String farmerPassword)
	{
		return farmerrepo.findByFarmerEmailAndFarmerPassword(farmerEmail, farmerPassword);
		
	}
}
