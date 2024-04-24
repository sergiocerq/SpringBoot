package com.teste.novomicrosservicos.dtos;

import com.teste.novomicrosservicos.entities.Email;

public record EmailDTO(String mailFrom, String mailTo, String mailSubject, String mailText) {
    public EmailDTO(Email email) {
        this(email.getMailFrom(), email.getMailTo(), email.getMailSubject(), email.getMailText());
    }
}
