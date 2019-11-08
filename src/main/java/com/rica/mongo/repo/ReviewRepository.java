package com.rica.mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rica.mongo.model.Review;

public interface ReviewRepository extends MongoRepository<Review, String>{

}
