package io.cropProject.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.cropProject.model.Transaction;

public interface TransRepo extends MongoRepository<Transaction, String> {
	public Transaction findByOrderId(String orderid);
}
