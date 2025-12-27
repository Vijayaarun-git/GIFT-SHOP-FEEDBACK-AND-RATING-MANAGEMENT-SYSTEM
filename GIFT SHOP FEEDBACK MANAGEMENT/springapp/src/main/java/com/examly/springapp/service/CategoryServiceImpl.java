package com.examly.springapp.service;

import com.examly.springapp.model.Category;
import com.examly.springapp.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public Page<Category> getAllCategoryPaginated(Pageable pageable) {
        return categoryRepo.findAll(pageable);
    }

    @Override
    public Category getCategory(long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public Category updateCategory(long id, Category category) {
        if (categoryRepo.existsById(id)) {
            category.setCategoryId(id);
            return categoryRepo.save(category);
        }
        return null;
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepo.deleteById(id);
    }
    
    @Override
    public void deleteAllCategories() {
        categoryRepo.deleteAll();
    }
}