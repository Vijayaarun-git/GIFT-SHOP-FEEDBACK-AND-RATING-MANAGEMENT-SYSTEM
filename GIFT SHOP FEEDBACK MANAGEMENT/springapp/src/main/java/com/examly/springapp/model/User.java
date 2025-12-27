package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long userId;

    private String username;

    private String role;

    private String email;

    public User(){}

    public User(String username,String role,String email){
        this.username=username;
        this.role=role;
        this.email=email;
    }

    public long getId(){
        return userId;
    }
    public void setId(long userId){
        this.userId=userId;
    }

    public long getUserId(){
        return userId;
    }
    public void setUserId(long userId){
        this.userId=userId;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }

    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role=role;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
}
