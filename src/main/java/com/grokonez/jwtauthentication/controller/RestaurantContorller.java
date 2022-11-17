package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.model.Category;
import com.grokonez.jwtauthentication.model.Plat;
import com.grokonez.jwtauthentication.services.CategorySer;
import com.grokonez.jwtauthentication.services.PlatService;
import com.grokonez.jwtauthentication.services.RestaurantService;
import com.grokonez.jwtauthentication.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@Component
public class RestaurantContorller {
    @Autowired
    RestaurantService  service;
    @Autowired
    PlatService platservice;
    @Autowired
    CategorySer categoryser;
    @Autowired
    public RestaurantContorller(RestaurantService service) {
        this.service = service;
    }
    @GetMapping("/Restaurant/all")
    public List<Restaurant> getAllRestaurant () {
        List<Restaurant> restaurants = service.findAllRestaurant();
        return restaurants;
    }

    @GetMapping("/Restaurant/find/{id}")
    public Restaurant getRestaurantById (@PathVariable("id") Long id) {
        Restaurant Restaurant = service.findRestaurantById(id);
        return Restaurant;
    }
    @RequestMapping("/Restaurant/find")
    public Set<Restaurant> getRestaurantByName (@RequestParam(value = "name") String name) {
        Set<Restaurant> Restaurants = service.findRestaurantByName(name);
        return Restaurants;
    }

    @PostMapping("/Restaurant/add")
    public Restaurant addRestaurant(@RequestBody Restaurant Restaurant) {
        return service.addRestaurant(Restaurant);

    }

    @PutMapping("/Restaurant/update")
    public Restaurant updateRestaurant(@RequestBody Restaurant Restaurant) {
        return service.updateRestaurant(Restaurant);

    }

    @DeleteMapping("/Restaurant/delete/{id}")
    public void deleteRestaurant(@PathVariable("id") Long id) {
        service.deleteRestaurant(id);
    }
    @RequestMapping("Restaurant/Plat/add")
    public String addPlat(@RequestBody Plat plat,@RequestParam(value = "name") String name) {
        Restaurant restaurant = service.findRestaurantByName(name).iterator().next();
        Category cat = plat.getCategory();
        cat.setRestaurant(restaurant);
        categoryser.addCategory(cat);
        plat.setId(1L);
        plat.setRestaurant(restaurant);
        platservice.addPlat(plat);
        restaurant.getMenu().add(plat);
        Set<Category> categories = restaurant.getCategories();
        categories.add(plat.getCategory());
        restaurant.setCategories(categories);
        return "Added Successfully";
    }
}
