package com.rica.mongo.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rica.mongo.model.Address;
import com.rica.mongo.model.Review;
import com.rica.mongo.model.User;
import com.rica.mongo.repo.UserRepository;




@RestController
public class InitialForSampleData {
	
	@Autowired
	private UserRepository userA;
	
	
    public void UserRepository(UserRepository userA) {
        this.userA = userA;
    }
	
	//Create Sample inputs
	@RequestMapping("/")
	public String FreeMe() {
		Random ran =new Random();
		
		List<Review> rvlst= new ArrayList<>();
		Address r2=new Address("Istanbul","Turkey","Hakkas",(int)ran.nextInt(1000));
		
		for(int i=0;i<9;i++) {
			String name= "Ali "+(int)ran.nextInt(100);
			User nu=new User(name,r2,(int)ran.nextInt(90000)+10000);
			userA.save(nu);

		}
		
		
		return "Hello!";
	}

}
