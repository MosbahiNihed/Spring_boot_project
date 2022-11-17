package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.model.Plat;
import com.grokonez.jwtauthentication.model.Restaurant;
import com.grokonez.jwtauthentication.services.PlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlatController {
    @Autowired
    PlatService service;

    public PlatController(PlatService service) {
        this.service = service;
    }

    @GetMapping("/Plat/all")
    public List<Plat> getAllPlates () {
        List<Plat> plats = service.findAll();
        return plats;
    }
    @RequestMapping("/Plat/find")
    public List<Plat> getPlatById (@RequestParam(value = "name") String name) {
        List<Plat> plats = service.findPlatByName(name);
        return plats;
    }

}
