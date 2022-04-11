package io.cropProject.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.cropProject.model.Dealer;
@Repository
public interface DealerRepo extends MongoRepository<Dealer, String> {

	
	public Dealer findByDealerEmailAndDealerPassword(String dealerEmail,String dealerPassword);
	public Dealer findByDealerEmail(String dealeremail);
}
