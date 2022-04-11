package io.cropProject.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.cropProject.model.Product;

public interface ProductRepo extends MongoRepository<Product, String> {

	public List<Product> findByFarmerEmail(String farmeremail);

	public void delete(Product foundproduct);
}
