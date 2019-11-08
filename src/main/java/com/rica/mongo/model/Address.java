package com.rica.mongo.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter(AccessLevel.PUBLIC)
public class Address {
	private String city;
	private String country;
	private String street;
	private int number;
	public Address(String city, String country, String street, int number) {
		super();
		this.city = city;
		this.country = country;
		this.street = street;
		this.number = number;
	}
    
}
