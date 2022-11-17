package com.grokonez.jwtauthentication.model;

import org.hibernate.engine.internal.Cascade;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long uid;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    private Timestamp rsvdate;
    private Integer nbpers;
    private Integer rating;
    @OneToMany(mappedBy = "id")
    private Set<com.grokonez.jwtauthentication.model.Table> tables;



    public Reservation(Long uid, Restaurant rest, Timestamp rsvdate, Integer nbpers, Integer rating) {
        this.uid = uid;
        this.restaurant = rest;
        this.rsvdate = rsvdate;
        this.nbpers = nbpers;
        this.rating=rating;
    }

    public Reservation() {
    }

    public Long getRsvid() {
        return id;
    }

    public void setRsvid(Long rsvid) {
        this.id = rsvid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
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


    public Timestamp getRsvdate() {
        return rsvdate;
    }

    public void setRsvdate(Timestamp rsvdate) {
        this.rsvdate = rsvdate;
    }

    public Integer getNbpers() {
        return nbpers;
    }

    public void setNbpers(Integer nbpers) {
        this.nbpers = nbpers;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", uid=" + uid +
                ", restaurant=" + restaurant +
                ", rsvdate=" + rsvdate +
                ", nbpers=" + nbpers +
                ", rating=" + rating +
                '}';
    }
}

