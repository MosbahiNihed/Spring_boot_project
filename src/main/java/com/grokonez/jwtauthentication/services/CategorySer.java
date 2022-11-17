package com.grokonez.jwtauthentication.services;

import com.grokonez.jwtauthentication.model.Category;
import com.grokonez.jwtauthentication.model.Restaurant;


import java.util.List;

public interface CategorySer {
    public Category addCategory(Category category);
    public List<Category> findAllCategories();
    public Category updateCategory(Category category);
    public Category findCategoryById(Long id);
    public void deleteCategory(Long id);
}
