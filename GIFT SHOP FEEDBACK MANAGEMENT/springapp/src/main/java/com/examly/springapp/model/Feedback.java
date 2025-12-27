package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long feedbackId;

    private int rating;

    private String comment;

    private long userId;
    
    private long productId;

    public Feedback(){}

    public Feedback(int rating,String comment,long userId,long productId){
        this.rating=rating;
        this.comment=comment;
        this.userId=userId;
        this.productId=productId;
    }

    public long getFeedbackId(){
        return feedbackId;
    }
    public void setFeedbackId(long feedbackId){
        this.feedbackId=feedbackId;
    }

    public int getRating(){
        return rating;
    }
    public void setRating(int rating){
        this.rating=rating;
    }

    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment=comment;
    }

    public long getUserId(){
        return userId;
    }
    public void setUserId(long userId){
        this.userId=userId;
    }

    public long getProductId(){
        return productId;
    }
    public void setProductId(long productId){
        this.productId=productId;
    }
}
