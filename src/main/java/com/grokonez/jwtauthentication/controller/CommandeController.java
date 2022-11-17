package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.model.Commande;
import com.grokonez.jwtauthentication.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommandeController {
    @Autowired
    CommandeService service;

    public CommandeController(CommandeService service) {
        this.service = service;
    }

    @GetMapping("/Commande/all")
    public List<Commande> getAllRestaurant () {
        List<Commande> Commandes = service.findAllCommandes();
        return Commandes;
    }

    @GetMapping("/Commande/find/{id}")
    public Commande getRestaurantById (@PathVariable("id") Long id) {
        Commande commande = service.findCommandeById(id);
        return commande;
    }
    @RequestMapping("/Commande/findByUser")
    public List<Commande> getCommandesByUser (@RequestParam(value = "username") String name) {
        List<Commande> Commandes = service.findCommandeByUser(name);
        return Commandes;
    }
    @RequestMapping("/Commande/findByRestaurant")
    public List<Commande> getCommandesByRestaurant (@RequestParam(value = "nom") String name) {
        List<Commande> Commandes = service.findCommandeByRestaurant(name);
        return Commandes;
    }

    @PostMapping("/Commande/add")
    public Commande addRestaurant(@RequestBody Commande commande) {
        return service.addCommande(commande);

    }

    @PutMapping("/Commande/update")
    public Commande updateRestaurant(@RequestBody Commande commande) {
        return service.updateCommande(commande);

    }

    @DeleteMapping("/Commande/delete/{id}")
    public void deleteRestaurant(@PathVariable("id") Long id) {
        service.deleteCommandeById(id);
    }
}
