package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {
    void deleteCommandeById(Long id);

    Optional<Commande> findCommandeById(Long id);
    @Query(value="select * from Commande  where user.name = :username", nativeQuery = true)
    List<Commande> findCommandeByUser(@Param("username") String username);
    @Query(value="select * from Commande  where restaurant.nomrest = :nom", nativeQuery = true)
    List<Commande> finCommandeByRestaurant(@Param("nom") String nom);
}
