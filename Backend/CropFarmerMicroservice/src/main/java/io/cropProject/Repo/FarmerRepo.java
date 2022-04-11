package io.cropProject.Repo;




import org.springframework.data.mongodb.repository.MongoRepository;

import io.cropProject.model.Farmer;

public interface FarmerRepo extends MongoRepository<Farmer, String> {

	public Farmer findByFarmerEmail(String farmeremail);
	public Farmer findByFarmerEmailAndFarmerPassword(String farmerEmail,String farmerPassword);
}
