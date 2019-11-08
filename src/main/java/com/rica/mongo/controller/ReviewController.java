package com.rica.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rica.mongo.model.Review;
import com.rica.mongo.repo.ReviewRepository;

@RestController
@RequestMapping("rewiew")
public class ReviewController {

	@Autowired
	ReviewRepository reviewRepo;
	
	@GetMapping("/all")
	public List<Review> getReviews(){
		return reviewRepo.findAll();
	}
}
