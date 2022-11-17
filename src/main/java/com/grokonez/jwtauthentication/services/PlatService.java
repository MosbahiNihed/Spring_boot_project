package com.grokonez.jwtauthentication.services;

import com.grokonez.jwtauthentication.model.Plat;
import com.grokonez.jwtauthentication.model.Restaurant;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PlatService {
    public Plat addPlat(Plat plat);


    @Transactional
    List<Plat> findAll();

    public Plat updatePlat(Plat plat);

    @Transactional
    Plat findPlatById(Long id);

    public void deletePlatById(Long id);
    List<Plat> findPlatByName(String name);
}
