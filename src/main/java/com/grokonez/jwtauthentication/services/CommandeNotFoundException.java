package com.grokonez.jwtauthentication.services;

public class CommandeNotFoundException extends RuntimeException {
    public CommandeNotFoundException(String s) {
        super(s);
    }
}
