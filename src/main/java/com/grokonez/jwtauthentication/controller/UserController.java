package com.grokonez.jwtauthentication.controller;


import com.grokonez.jwtauthentication.message.request.SignUpForm;
import com.grokonez.jwtauthentication.message.response.ResponseMessage;
import com.grokonez.jwtauthentication.model.Role;
import com.grokonez.jwtauthentication.model.RoleName;
import com.grokonez.jwtauthentication.repository.RoleRepository;
import com.grokonez.jwtauthentication.repository.UserRepo;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.security.services.UserPrinciple;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.model.User;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static jdk.internal.dynalink.support.NameCodec.encode;

@RestController
class UserController {
    @Autowired
    UserDetailsService service;
    @Autowired
    UserRepo repository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository role;


    @GetMapping(path = "/UserDetails")
    public UserPrinciple ViewDetails(@AuthenticationPrincipal UserDetails logged, Model model){
        String username = logged.getUsername();
        UserPrinciple user = (UserPrinciple) service.loadUserByUsername(username);
        return user;
    }
    @PutMapping(path = "/update")
    public ResponseEntity<?> updateUser(@AuthenticationPrincipal UserPrinciple logged, @RequestBody User user) {
        Set<Role> roles = new HashSet<>();
        roles.add( role.findByName(RoleName.ROLE_CLIENT).get());
        User userupdated = new User(logged.getId(),user.getName(), logged.getUsername(), user.getEmail(), logged.getPassword(),user.getNumero(), roles);
        userRepository.save(userupdated);
        return new ResponseEntity<>(new ResponseMessage("User updated successfully!"), HttpStatus.OK);
    }


}
