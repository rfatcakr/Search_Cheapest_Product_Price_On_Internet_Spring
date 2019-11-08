package com.rica.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Document
@Getter @Setter(AccessLevel.PUBLIC)
public class User {
	
	@Id
	private String id;
	private String name;
	private Address address;
	@Indexed(direction = IndexDirection.ASCENDING)
	private int idNo;
	public User(String name, Address address, int idNo) {
		super();
		this.name = name;
		this.address = address;
		this.idNo = idNo;
	}

	
}
