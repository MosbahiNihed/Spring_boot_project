package com.grokonez.jwtauthentication.services;

import com.grokonez.jwtauthentication.model.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
