package com.grokonez.jwtauthentication.services;

import com.grokonez.jwtauthentication.model.Commande;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CommandeService {
    public Commande addCommande(Commande commande);


    @Transactional
    List<Commande> findAllCommandes();

    public Commande updateCommande(Commande commande);

    @Transactional
    Commande findCommandeById(Long id);

    public void deleteCommandeById(Long id);
    List<Commande> findCommandeByUser(String user);
    List<Commande> findCommandeByRestaurant(String restaurant);
}
