package com.grokonez.jwtauthentication.model;

import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nomrest;

    private String specialite;

    private String adresse;

    private double longitude;

    private double latitude;

    @OneToMany(mappedBy = "restaurant")
    private Set<Plat> menu;
    @OneToMany(mappedBy = "restaurant")
    private Set<Category> categories;

    @ManyToMany
    private Set<User> Users = new HashSet<>();
    private double rating;


    public Restaurant() {
    }

    public Restaurant(String nomrest, String specialite, String adresse, double longitude, double latitude, Set<Plat> menu, Set<Category> categories, double rating) {
        this.nomrest = nomrest;
        this.specialite = specialite;
        this.adresse = adresse;
        this.longitude = longitude;
        this.latitude = latitude;
        this.menu = menu;
        this.categories = categories;
        this.rating = rating;
    }

    public Restaurant(Long id, String nomrest, String specialite, String adresse, double longitude, double latitude, double rating) {
        this.id = id;
        this.nomrest = nomrest;
        this.specialite = specialite;
        this.adresse = adresse;
        this.longitude = longitude;
        this.latitude = latitude;
        this.rating = rating;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long rid) {
        this.id = rid;
    }

    public String getNomrest() {
        return nomrest;
    }

    public void setNomrest(String nomrest) {
        this.nomrest = nomrest;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Set<Plat> getMenu() {
        return menu;
    }

    public void setMenu(Set<Plat> menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", nomrest='" + nomrest + '\'' +
                ", specialite='" + specialite + '\'' +
                ", adresse='" + adresse + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", menu=" + menu +
                ", categories=" + categories +
                ", rating=" + rating +
                '}';
    }
}
