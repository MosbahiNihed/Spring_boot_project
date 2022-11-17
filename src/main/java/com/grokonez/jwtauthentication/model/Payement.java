package com.grokonez.jwtauthentication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@javax.persistence.Table(name = "payment")
public class Payement {
    @Id
    private Long id;
    private Long cardid;

    public Payement(Long id, Long cardid) {
        this.id = id;
        this.cardid = cardid;
    }

    public Payement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long payid) {
        this.id = payid;
    }

    public Long getCardid() {
        return cardid;
    }

    public void setCardid(Long cardid) {
        this.cardid = cardid;
    }



    @Override
    public String toString() {
        return "Payement{" +
                "id=" + id +
                ", cardid=" + cardid +
                '}';
    }
}

