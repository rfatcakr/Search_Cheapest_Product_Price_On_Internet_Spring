package com.rica.mongo.controller;

import static org.mockito.Matchers.booleanThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rica.mongo.model.Product;
import com.rica.mongo.preprogres.HandleProductQuery;
import com.rica.mongo.repo.ProductRepository;



@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductRepository productRepo;
	
	@GetMapping
	public List<Product> getAll() {
		return productRepo.findAll();
	}
	
	@GetMapping("/query/{name}")
	public Product findProduct(@PathVariable("name") String name) {
		Product query= productRepo.findProductByName(name);
		//return query!=null?query:new HandleProductQuery().findProduct(name);
		boolean a=false;
		if(query==null)
			a=!a;
		query=(query!=null)?query:new HandleProductQuery().findProduct(name);

		//Increment ProductNo
		if(a)
			productRepo.insert(query);
		return query;
	}
	

	
}
