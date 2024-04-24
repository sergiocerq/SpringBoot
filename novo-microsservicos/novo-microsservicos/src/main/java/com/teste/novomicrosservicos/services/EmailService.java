package com.teste.novomicrosservicos.services;

import com.teste.novomicrosservicos.dtos.EmailDTO;
import com.teste.novomicrosservicos.entities.Email;
import com.teste.novomicrosservicos.enums.EmailStatus;
import com.teste.novomicrosservicos.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public Email sendEmail(EmailDTO emailDTO) {
        Email data = new Email(emailDTO);
        data.setSendDateEmail(LocalDateTime.now());
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailDTO.mailFrom());
        message.setSubject(emailDTO.mailSubject());
        message.setTo(emailDTO.mailTo());
        message.setText(emailDTO.mailText());
        data.setStatus(EmailStatus.SENT);
        javaMailSender.send(message);
        emailRepository.save(data);
        return data;
    }
}
