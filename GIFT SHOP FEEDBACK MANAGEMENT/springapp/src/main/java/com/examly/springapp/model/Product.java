package com.examly.springapp.model;
import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    
    private String productName;

    private String description;

    private double price;

    private int stockQuantity;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Product(){}

    public Product(String productName,String description,double price,int stockQuantity,Category category){
        this.productName=productName;
        this.description=description;
        this.price=price;
        this.stockQuantity=stockQuantity;
        this.category=category;
    }

    public long getProductId(){
        return productId;
    }
    public void setProductId(long productId){
        this.productId=productId;
    }

    public String getProductName(){
        return productName;
    }
    public void setProductName(String productName){
        this.productName=productName;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }

    public int getStockQuantity(){
        return stockQuantity;
    }
    public void setStockQuantity(int stockQuantity){
        this.stockQuantity=stockQuantity;
    }
    
    public Category getCategory(){
        return category;
    }
    public void setCategory(Category category){
        this.category=category;
    }
}
