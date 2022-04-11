package io.cropProject.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.cropProject.model.Productorder;

public interface Productorderrepo extends MongoRepository<Productorder, String> {
	public List<Productorder> findByDealerEmail(String dealeremail);
}
