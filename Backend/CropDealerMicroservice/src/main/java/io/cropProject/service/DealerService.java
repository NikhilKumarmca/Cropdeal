package io.cropProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.cropProject.model.Dealer;
import io.cropProject.model.Productorder;
import io.cropProject.repo.DealerRepo;
import io.cropProject.repo.Productorderrepo;

@Service
public class DealerService {
	
	@Autowired
	public DealerRepo dealerrepo;
	
	@Autowired
	public Productorderrepo orderrepo;

	public List<Dealer> getAlldealer() {
		
		return dealerrepo.findAll();
	}

	
	public Dealer getDealerbyemail(String dealeremail) {
		
		return dealerrepo.findByDealerEmail(dealeremail);
	}

	public Dealer AddDealer(Dealer dealer) {
		
		return dealerrepo.save(dealer);
	}

	public Dealer updateDealer(Dealer updated_dealer) {
		   return dealerrepo.save(updated_dealer);  
	}

	public String deleteDealer(String dealerid) {
		dealerrepo.deleteById(dealerid);
		return dealerid+" was deleted successfully";
	}

	public Productorder Ordercreate(Productorder order) {
		return orderrepo.save(order);
	}
 

	
	public Dealer getLogin(String dealerEmail,String dealerPassword)
	{
		return dealerrepo.findByDealerEmailAndDealerPassword(dealerEmail, dealerPassword);
		
	}

	public List<Productorder> getorderbyid(String dealeremail) {
		return orderrepo.findByDealerEmail(dealeremail);
	}

}
