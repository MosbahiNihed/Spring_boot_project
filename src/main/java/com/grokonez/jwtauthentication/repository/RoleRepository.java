package com.grokonez.jwtauthentication.repository;

import java.util.Optional;

import com.grokonez.jwtauthentication.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grokonez.jwtauthentication.model.Role;
import com.grokonez.jwtauthentication.model.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
    void deleteRoleById(Long id);

    Optional<Role> findRoleById(Long id);

    //Optional<RoleName> findAllRoleName();
}