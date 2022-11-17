package com.grokonez.jwtauthentication.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    private String name;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;

    @NaturalId(mutable = true)
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
    	joinColumns = @JoinColumn(name = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    private String numero;

    public User(Long id, String name, String username, String email, String password, String numero,Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.numero=numero;
        this.roles=roles;
    }


    @ManyToMany
    private Set<Restaurant> restaurant = new HashSet<>();
    public User() {}

    public User(String name, String username, String email, String password,Set<Role> roles,String numero) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles=roles;
        this.numero=numero;
    }

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(Long id, String name, String username, String password, String email,String numero) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password=password;
        this.email = email;
        this.numero=numero;

    }

    public User(Long id, String name, String username, String email, String encode) {
        this.id = id;
        this.name=name;
        this.username=username;
        this.email=email;
        this.password=encode;
    }

    public User(Long id,String name, String email, String numero) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.numero = numero;
    }

    public User(String name, String username, String email, String encode, String numero) {
        this.id = id;
        this.name=name;
        this.username=username;
        this.email=email;
        this.password=encode;
        this.numero=numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }


}