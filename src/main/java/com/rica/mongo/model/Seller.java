package com.rica.mongo.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Document
@Getter @Setter(AccessLevel.PUBLIC)
public class Seller {
	private String name;
	private String price;
	private String url;
}
