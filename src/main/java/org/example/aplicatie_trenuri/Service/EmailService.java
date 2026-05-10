package org.example.aplicatie_trenuri.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void trimiteEmail(String email) {
        trimiteEmail(
                email,
                "Rezervare tren",
                "Rezervarea a fost efectuata."
        );
    }

    public void trimiteEmail(String email, String subiect, String mesajText) {
        SimpleMailMessage mesaj = new SimpleMailMessage();

        mesaj.setTo(email);
        mesaj.setSubject(subiect);
        mesaj.setText(mesajText);

        mailSender.send(mesaj);
    }
}