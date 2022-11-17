package com.grokonez.jwtauthentication.model;

import javax.persistence.*;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "plat")
public class Plat {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore
    private Restaurant restaurant;
    private double prix;
    private Integer qte;
    private String nomplat;
    private String description;
    private Integer rating;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public String getNomplat() {
        return nomplat;
    }

    public void setNomplat(String nomplat) {
        this.nomplat = nomplat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Plat(Restaurant restaurant, double prix, Integer qte, String nomplat, String description, Integer rating, Category category) {
        this.restaurant = restaurant;
        this.prix = prix;
        this.qte = qte;
        this.nomplat = nomplat;
        this.description = description;
        this.rating = rating;
        this.category = category;
    }

    public Plat(Restaurant restaurant, double prix, String nomplat, String description, Integer rating, Category category) {
        this.prix = prix;
        this.nomplat = nomplat;
        this.description = description;
        this.rating = rating;
        this.category = category;
    }

    public Plat() {
    }

    @Override
    public String toString() {
        return "Plat{" +
                "id=" + id +
                ", prix=" + prix +
                ", qte=" + qte +
                ", nomplat='" + nomplat + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                '}';
    }
}
