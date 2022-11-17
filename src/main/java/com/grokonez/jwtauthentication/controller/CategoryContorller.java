package com.grokonez.jwtauthentication.controller;


import com.grokonez.jwtauthentication.model.Category;
import com.grokonez.jwtauthentication.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
public class CategoryContorller {
    @Autowired
    CategoryService service;

    public CategoryContorller(CategoryService service) {
        this.service = service;
    }
    @GetMapping("/Category/all")
    public List<Category> getAllCommandes () {
        List<Category> Categories = service.findAllCategories();
        return Categories;
    }

    @GetMapping("/Category/find/{id}")
    public Category getCommandeById (@PathVariable("id") Long id) {
        Category category = service.findCategoryById(id);
        return category;
    }

    @PostMapping("/Category/add")
    public Category addCategory(@RequestBody Category category) {
        return service.addCategory(category);

    }

    @PutMapping("/Category/update")
    public Category updateCategory(@RequestBody Category category) {
        return service.updateCategory(category);

    }

    @DeleteMapping("/Category/delete/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        service.deleteCategory(id);
    }
}
