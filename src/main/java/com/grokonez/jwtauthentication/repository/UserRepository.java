package com.grokonez.jwtauthentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grokonez.jwtauthentication.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String query);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<User> findById(int Id);

}