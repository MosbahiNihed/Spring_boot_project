package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.Plat;
import com.grokonez.jwtauthentication.model.Restaurant;
import com.grokonez.jwtauthentication.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findRestaurantById(long id);

    void deleteRestaurantById(Long id);
    @Query(value="select * from restaurant  where nomrest = :nom", nativeQuery = true)
    Set<Restaurant> findByName(@Param("nom") String nom);
}
