package com.rica.mongo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.rica.mongo.model.User;



public interface UserRepository extends MongoRepository<User,String>, QueryDslPredicateExecutor<User> {

	User findById(String id);


	User findByName(String name);




    @Query(value = "{address.city:?0}")
    List<User> findByCity(String city);






}
