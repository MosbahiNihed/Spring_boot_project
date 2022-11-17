package com.grokonez.jwtauthentication.services;

import com.grokonez.jwtauthentication.model.Role;
import com.grokonez.jwtauthentication.model.RoleName;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoleSer {
    public Role addRole(Role role);
    public List<Role> findAllRoles();
    public Role updateRoles(Role role);

    @Transactional
    List<Role> findAllRole();

    @Transactional
    Role updateRole(Role Role);
    @Transactional

    public Role findRoleById(Long id);

    @Transactional
    Role findRoleByName(RoleName rolename);

    public void deleteRole(Long id);
}
