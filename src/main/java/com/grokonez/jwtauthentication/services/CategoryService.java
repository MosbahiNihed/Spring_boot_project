package com.grokonez.jwtauthentication.services;


import com.grokonez.jwtauthentication.model.Category;
import com.grokonez.jwtauthentication.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
public class CategoryService implements CategorySer{

    @Autowired
    CategoryRepository repository;


    @Override
    @Transactional
    public Category addCategory(Category category) {
        return repository.save(category);
    }

    @Override
    @Transactional
    public List<Category> findAllCategories() {
        return repository.findAll();    }

    @Override
    @Transactional
    public Category updateCategory(Category category) {
        return repository.save(category);
    }

    @Override
    @Transactional
    public Category findCategoryById(Long id) {
        return repository.findCategoryById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Category with id " + id + " was not found"));
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        repository.deleteCategoryById(id);
    }

}
 class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}