package com.grokonez.jwtauthentication.services;

import com.grokonez.jwtauthentication.model.Plat;
import com.grokonez.jwtauthentication.repository.PlatRepository;
import com.grokonez.jwtauthentication.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlatServiceImpl implements PlatService{
    @Autowired
    PlatRepository repository;

    @Override
    public Plat addPlat(Plat plat) {
        return repository.save(plat);
    }

    @Override
    public List<Plat> findAll() {
        return repository.findAll();
    }

    @Override
    public Plat updatePlat(Plat plat) {
        return repository.save(plat);
    }

    @Override
    public Plat findPlatById(Long id) {
        return repository.findPlatById(id)
                .orElseThrow(() -> new PlatNotFoundException("Plat with id " + id + " was not found"));
    }

    @Override
    public void deletePlatById(Long id) {
        repository.deletePlatById(id);
    }

    @Override
    public List<Plat> findPlatByName(String name) {
        return repository.findByName(name);
    }
}
