package com.grokonez.jwtauthentication.services;

import com.grokonez.jwtauthentication.model.Restaurant;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface RestaurantSer {

    public Restaurant addRestaurant(Restaurant restau);


    @Transactional
    List<Restaurant> findAllRestaurant();

    public Restaurant updateRestaurant(Restaurant restau);

    @Transactional
    Restaurant findRestaurantById(Long id);

    public void deleteRestaurant(Long id);
    Set<Restaurant> findRestaurantByName(String name);


}
