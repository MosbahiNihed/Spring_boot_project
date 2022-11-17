package com.grokonez.jwtauthentication.services;

import com.grokonez.jwtauthentication.model.Restaurant;

import com.grokonez.jwtauthentication.repository.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Component
public class RestaurantService implements RestaurantSer{

    @Autowired
    RestaurantRepository repository;


    @Override
    @Transactional
    public Restaurant addRestaurant(Restaurant Restaurant) {
        return repository.save(Restaurant);
    }

    @Override
    @Transactional
    public List<Restaurant> findAllRestaurant() {
        return repository.findAll();    }

    @Override
    @Transactional
    public Restaurant updateRestaurant(Restaurant Restaurant) {
        return repository.save(Restaurant);
    }

    @Override
    @Transactional
    public Restaurant findRestaurantById(Long id) {
        return repository.findRestaurantById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant with id " + id + " was not found"));
    }

    @Override
    @Transactional
    public void deleteRestaurant(Long id) {
        repository.deleteRestaurantById(id);
    }

    @Override
    public Set<Restaurant> findRestaurantByName(String name) {
        return repository.findByName(name);
    }

}
 class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(String message) {
        super(message);
    }
}