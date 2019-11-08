package com.rica.mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.rica.mongo.model.Product;


public interface ProductRepository extends MongoRepository<Product, Long> {
	
	Product findByName(String name);
	@Query("{ 'name' : ?0 }")
	Product findProductByName(String name);
}
