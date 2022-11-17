package com.grokonez.jwtauthentication.repository;

import com.grokonez.jwtauthentication.message.response.ResponseMessage;
import com.grokonez.jwtauthentication.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserRepo  {
        @Autowired
        private EntityManager entityManager;


        public ResponseEntity<?> SavingUpdating(User user){
            Session currentSession = entityManager.unwrap(Session.class);
            currentSession.merge(user);
            return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
        }
}

