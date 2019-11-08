package com.rica.mongo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Document
@Getter @Setter(AccessLevel.PUBLIC)
public class Product {
	
	@Id
	private String name;
	private List<Staff> staff; 

}
