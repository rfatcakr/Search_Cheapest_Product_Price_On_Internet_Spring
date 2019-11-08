package com.rica.mongo.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


@Document
@Getter @Setter(AccessLevel.PUBLIC)
public class Staff {
	private String imgUrl;
	private String ProductName;
	private List<Seller> sellers;
	
}
