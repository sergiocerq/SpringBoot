package com.teste.novomicrosservicos.controllers;

import com.teste.novomicrosservicos.dtos.EmailDTO;
import com.teste.novomicrosservicos.entities.Email;
import com.teste.novomicrosservicos.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCheckpointRestore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    private ResponseEntity<Email> sendEmail(EmailDTO emailDTO) {
        return new ResponseEntity<Email>(emailService.sendEmail(emailDTO), HttpStatus.CREATED);
    }

}
