package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long categoryId;

    private String categoryName;

    public Category(){}

    public Category(String categoryName){
        this.categoryName=categoryName;
    }

    public long getCategoryId(){
        return categoryId;
    }
    public void setCategoryId(long categoryId){
        this.categoryId=categoryId;
    }

    public String getCategoryName(){
        return categoryName;
    }
    public void setCategoryName(String categoryName){
        this.categoryName=categoryName;
    }
}
