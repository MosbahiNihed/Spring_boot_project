package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.RoleService;
import com.grokonez.jwtauthentication.model.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {

	RoleService service;
	
	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String userAccess() {
		return ">>> User Contents!";
	}

	@GetMapping("/api/test/pm")
	@PreAuthorize("hasRole('ROLE_PM') or hasRole('ROLE_ADMIN')")
	public String projectManagementAccess() {
		return ">>> Project Management Board";
	}
	@GetMapping("/api/test/gerant")
	@PreAuthorize("hasRole('ROLE_GERANT') or hasRole('ROLE_ADMIN')")
	public String GerantManagementAccess() {
		return ">>> Restaurant Management Board";
	}
	
	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String adminAccess() {
		return ">>> Admin Contents";
	}

	@GetMapping("/api/test/roles")
	public Role getAllRoles(){
		List<Role> roles = service.findAllRoles();
		return (Role) roles;
	}
}