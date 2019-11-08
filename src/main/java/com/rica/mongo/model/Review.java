package com.rica.mongo.model;



import org.springframework.beans.factory.annotation.Autowired;

import lombok.AccessLevel;
import lombok.Getter;


@Getter (AccessLevel.PUBLIC)
public class Review {

    private String userId;
    private int rating;
    private boolean approved;
    private String comment;

    protected Review() {
    }

    public Review(String userId, int rating, String comment, boolean approved) {
        this.userId = userId;
        this.rating = rating;
        this.approved = approved;
        this.comment=comment;
    }

    public boolean isApproved() {
        return approved;
    }
}