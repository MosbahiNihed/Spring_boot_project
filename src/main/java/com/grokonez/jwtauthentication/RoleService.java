package com.grokonez.jwtauthentication;

import com.grokonez.jwtauthentication.model.Role;
import com.grokonez.jwtauthentication.model.RoleName;
import com.grokonez.jwtauthentication.repository.RoleRepository;
import com.grokonez.jwtauthentication.services.RoleSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
public class RoleService implements RoleSer {

    @Autowired
    RoleRepository repository;


    @Override
    @Transactional
    public Role addRole(Role Role) {
        return repository.save(Role);
    }

    @Override
    public List<Role> findAllRoles() {

        return repository.findAll();
    }


    @Override
    public Role updateRoles(Role role) {
        return null;
    }


    @Override
    public List<Role> findAllRole() {
        return null;
    }

    @Override
    @Transactional
    public Role updateRole(Role Role) {
        return repository.save(Role);
    }



    @Override
    @Transactional
    public Role findRoleById(Long id) {
        return repository.findRoleById(id)
                .orElseThrow(() -> new RoleNotFoundException("Role with id " + id + " was not found"));
    }

    @Override
    @Transactional
    public Role findRoleByName(RoleName rolename){
        return repository.findByName(rolename)
                .orElseThrow(() -> new RoleNotFoundException("Role with name " + rolename + " was not found"));
    }

    @Override
    @Transactional
    public void deleteRole(Long id) {
        repository.deleteRoleById(id);
    }
}
 class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(String message) {
        super(message);
    }
}