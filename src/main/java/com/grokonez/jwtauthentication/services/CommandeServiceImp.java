package com.grokonez.jwtauthentication.services;

import com.grokonez.jwtauthentication.model.Commande;
import com.grokonez.jwtauthentication.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandeServiceImp implements CommandeService{

    @Autowired
    CommandeRepository repository;
    @Override
    public Commande addCommande(Commande commande) {
        return repository.save(commande);
    }

    @Override
    public List<Commande> findAllCommandes() {
        return  repository.findAll();
    }

    @Override
    public Commande updateCommande(Commande commande) {
        return  repository.save(commande);
    }

    @Override
    public Commande findCommandeById(Long id) {
        return repository.findCommandeById(id)
                .orElseThrow(() -> new CommandeNotFoundException("Commande with id " + id + " was not found"));
    }

    @Override
    public void deleteCommandeById(Long id) {
        repository.deleteCommandeById(id);
    }

    @Override
    public List<Commande> findCommandeByUser(String user) {
        return repository.findCommandeByUser(user);
    }

    @Override
    public List<Commande> findCommandeByRestaurant(String restaurant) {
        return repository.findCommandeByUser(restaurant);
    }
}
