package com.grokonez.jwtauthentication.services;

public class PlatNotFoundException extends RuntimeException {
    public PlatNotFoundException(String s) {
        super(s);
    }
}
