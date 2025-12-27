package com.examly.springapp.service;

import com.examly.springapp.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    List<Category> getAllCategory();
    Page<Category> getAllCategoryPaginated(Pageable pageable);
    Category getCategory(long id);
    Category updateCategory(long id, Category category);
    void deleteCategory(long id);
    void deleteAllCategories();
}