package com.examly.springapp.controller;
import com.examly.springapp.model.Product;
import com.examly.springapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = service.getAllProduct();
        if (products.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(products);
    }    
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product saved = service.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        Product product = service.getProduct(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @PutMapping("/{id}")
  public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product) {
    Product updated = service.updateProduct(id, product);
    if (updated != null) {
      return ResponseEntity.ok(updated);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
    service.deleteProduct(id);
    return ResponseEntity.ok().build();
  }
  
  @GetMapping("/category/{categoryName}")
  public ResponseEntity<List<Product>> getProductsByCategoryName(@PathVariable String categoryName) {
    List<Product> products = service.getProductsByCategoryName(categoryName);
    return ResponseEntity.ok(products);
  }
  
  @GetMapping("/name/{productName}")
  public ResponseEntity<?> getProductByName(@PathVariable String productName) {
    List<Product> products = service.getProductsByName(productName);
    if (products.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("No products found with name: " + productName);
    }
    return ResponseEntity.ok(products);
  }
}