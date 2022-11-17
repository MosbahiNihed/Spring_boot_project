package com.grokonez.jwtauthentication.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "Commande")
public class Commande  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name="User_id")
    private User user;
    @ManyToOne
    @JoinColumn(name="Restaurant_id")
    @Transient
    private  Restaurant restaurant;

    @Transient
    @OneToMany(mappedBy = "id")
    private Set<Plat> plat;
    private Long tot;
    private double longitude;

    private double latitude;
    private String adresse;

    private Boolean validation;
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payement_id", referencedColumnName = "id")
    private Payement payement;


    public Commande() {
    }

    public Commande(User user, Restaurant restaurant, Set<Plat> plat, Long tot, double longitude, double latitude, String adresse, Boolean validation, Date date, Payement payement) {
        this.user = user;
        this.restaurant = restaurant;
        this.plat = plat;
        this.tot = tot;
        this.longitude = longitude;
        this.latitude = latitude;
        this.adresse = adresse;
        this.validation = validation;
        this.date = date;
        this.payement = payement;
    }

    public long getId() {
        return id;
    }

    public void setId(long Id) {
        this.id = Id;
    }

    public Payement getPayement() {
        return payement;
    }

    public void setPayement(Payement payement) {
        this.payement = payement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Plat> getPlat() {
        return plat;
    }

    public void setPlat(Set<Plat> plat) {
        this.plat = plat;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
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


    public Long getTot() {
        return tot;
    }

    public void setTot(Long tot) {
        this.tot = tot;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {this.adresse = adresse;
    }

    public Boolean getValidation() {
        return validation;
    }

    public void setValidation(Boolean validation) {
        this.validation = validation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", user=" + user +
                ", restaurant=" + restaurant +
                ", plat=" + plat +
                ", tot=" + tot +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", adresse='" + adresse + '\'' +
                ", validation=" + validation +
                ", date=" + date +
                '}';
    }
}
