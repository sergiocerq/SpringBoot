package com.teste.novomicrosservicos.entities;

import com.teste.novomicrosservicos.dtos.EmailDTO;
import com.teste.novomicrosservicos.enums.EmailStatus;
import jakarta.persistence.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

@Entity(name = "emails")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String mailFrom;
    private String mailTo;
    private String mailSubject;
    private String mailText;
    private LocalDateTime sendDateEmail;
    @Enumerated(EnumType.String)
    private EmailStatus status = EmailStatus.SENT;

    public Email(EmailDTO emailDTO) {
        this.mailTo = emailDTO.mailTo();
        this.mailFrom = emailDTO.mailFrom();
        this.mailText = emailDTO.mailText();
        this.mailSubject = emailDTO.mailSubject();
    }

    public String getId() {
        return id;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public String getMailTo() {
        return mailTo;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public String getMailText() {
        return mailText;
    }

    public LocalDateTime getSendDateEmail() {
        return sendDateEmail;
    }

    public EmailStatus getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public void setMailText(String mailText) {
        this.mailText = mailText;
    }

    public void setSendDateEmail(LocalDateTime sendDateEmail) {
        this.sendDateEmail = sendDateEmail;
    }

    public void setStatus(EmailStatus status) {
        this.status = status;
    }
}
