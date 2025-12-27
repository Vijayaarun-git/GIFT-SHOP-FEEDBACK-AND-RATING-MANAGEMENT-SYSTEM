package com.examly.springapp.service;

import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    @Override
    public Page<Product> getAllProductPaginated(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    @Override
    public Product getProduct(long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(long id, Product product) {
        if (productRepo.existsById(id)) {
            product.setProductId(id);
            return productRepo.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(long id) {
        productRepo.deleteById(id);
    }
    
    @Override
    public List<Product> getProductsByCategoryName(String categoryName) {
        return productRepo.findByCategoryName(categoryName);
    }
    
    @Override
    public List<Product> getProductsByName(String productName) {
        return productRepo.findByProductName(productName);
    }
}