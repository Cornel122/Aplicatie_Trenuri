package org.example.aplicatie_trenuri.Service;

import org.example.aplicatie_trenuri.DTO.LoginRequest;
import org.example.aplicatie_trenuri.DTO.SignupRequest;
import org.example.aplicatie_trenuri.Model.Utilizatori;
import org.example.aplicatie_trenuri.Repository.UtilizatoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UtilizatoriRepository utilizatoriRepository;

    public String signup(SignupRequest request) {

        Utilizatori utilizator = new Utilizatori();

        utilizator.setNume(request.getNume());
        utilizator.setParola(request.getParola());
        utilizator.setRol(request.getRol());

        utilizatoriRepository.save(utilizator);

        return "Cont creat";
    }

    public String login(LoginRequest request) {

        Utilizatori utilizator =
                utilizatoriRepository.findByNume(request.getNume());

        if (utilizator == null) {
            return "Utilizator inexistent";
        }

        if (!utilizator.getParola().equals(request.getParola())) {
            return "Parola gresita";
        }

        return "Login reusit";
    }
    public Utilizatori getUtilizator(String nume) {

        return utilizatoriRepository.findByNume(nume);
    }
}