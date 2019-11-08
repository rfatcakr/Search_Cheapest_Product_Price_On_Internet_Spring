package com.rica.mongo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.rica.mongo.model.QUser;
import com.rica.mongo.model.User;
import com.rica.mongo.repo.UserRepository;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/all")
	public List<User> getAll(){
		return userRepo.findAll();
		
	}
	
	@PostMapping("/")
	public void postUser(@Valid @RequestBody User user) {
		userRepo.save(user);		
	}
	
	@PutMapping("/")
	public void updateUser(@Valid @RequestBody User user) {
		userRepo.insert(user);
	}
	
	@DeleteMapping("/")
	public void deleteUser(User user) {
		userRepo.delete(user);
	}
	
	@GetMapping("/{id}")
	public User getUserbyId(@PathVariable("id") String id) {
		return userRepo.findById(id);
		
	}
	
	@GetMapping("/query/{name}")
	public User getuserName(@PathVariable("name") String name){
		return userRepo.findByName(name);
	}
	

	
    @GetMapping("/address/city/{city}")
    public List<User> getByCity(@PathVariable("city") String city){
        return this.userRepo.findByCity(city);

    }
    
    @GetMapping("/address/country/{country}")
    public List<User> getByCountry(@PathVariable("country") String country){
		QUser userq= new QUser("user");
		BooleanExpression filterByCountry = userq.address.country.eq(country);
		List<User> users = (List<User>) userRepo.findAll(filterByCountry);
		return users;
    }

    
	
}
