package com.grokonez.jwtauthentication.model;

import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@javax.persistence.Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    private String desc;
    private Integer rate;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user;

    private Timestamp datefb;

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Feedback() {
    }

    public Feedback(Restaurant restaurant, String desc, Integer rate, User user, Timestamp datefb) {
        this.restaurant = restaurant;
        this.desc = desc;
        this.rate = rate;
        this.user = user;
        this.datefb = datefb;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long fid) {
        this.id = fid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }


    public Timestamp getDatefb() {
        return datefb;
    }

    public void setDatefb(Timestamp datefb) {
        this.datefb = datefb;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", restaurant=" + restaurant +
                ", desc='" + desc + '\'' +
                ", rate=" + rate +
                ", user=" + user +
                ", datefb=" + datefb +
                '}';
    }
}

