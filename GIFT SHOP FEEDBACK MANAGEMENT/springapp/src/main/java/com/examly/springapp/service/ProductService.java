package com.examly.springapp.service;

import com.examly.springapp.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProduct();
    Product getProduct(long id);
    Product updateProduct(long id, Product product);
    void deleteProduct(long id);
    
    Page<Product> getAllProductPaginated(Pageable pageable);
    List<Product> getProductsByCategoryName(String categoryName);
    List<Product> getProductsByName(String productName);
}