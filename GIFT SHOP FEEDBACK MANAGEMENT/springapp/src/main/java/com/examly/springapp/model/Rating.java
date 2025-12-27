package com.examly.springapp.model;
import jakarta.persistence.*;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long ratingId;

    private int score;

    private long userId;

    private long productId;

    public Rating(){}

    public Rating(int score,long userId,long productId){
        this.score=score;
        this.userId=userId;
        this.productId=productId;
    }

    public long getRatingId(){
        return ratingId;
    }
    public void setRatingId(long ratingId){
        this.ratingId=ratingId;
    }

    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score=score;
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
