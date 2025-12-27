package com.examly.springapp.controller;
import com.examly.springapp.model.Category;
import com.examly.springapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService service;
    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody(required = false) Category category) {
        if (category == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (category.getCategoryName() == null || category.getCategoryName().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Category saved = service.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        List<Category> categories = service.getAllCategory();        
        if (categories.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }        
        return ResponseEntity.ok(categories);
    }
    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<Category>> getCategoriesPaginated(
            @PathVariable int page,
            @PathVariable int size) {        
        Pageable pageable = PageRequest.of(page, size, Sort.by("categoryId").ascending());
        Page<Category> categories = service.getAllCategoryPaginated(pageable);
        return ResponseEntity.ok(categories);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable long id) {
        Category category = service.getCategory(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable long id, @RequestBody Category category) {
        Category updated = service.updateCategory(id, category);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable long id) {
    service.deleteCategory(id);
    return ResponseEntity.ok().build();
    }
    
    @DeleteMapping
    public ResponseEntity<Void> deleteAllCategories() {
        service.deleteAllCategories();
        return ResponseEntity.ok().build();
    }
}