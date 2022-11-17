package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    void deleteCategoryById(Long id);

    Optional<Category> findCategoryById(Long id);
}
