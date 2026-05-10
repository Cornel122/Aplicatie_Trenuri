package org.example.aplicatie_trenuri.Service;

import org.example.aplicatie_trenuri.DTO.RezervareRequest;
import org.example.aplicatie_trenuri.Model.Rezervare;
import org.example.aplicatie_trenuri.Model.Tren;
import org.example.aplicatie_trenuri.Model.Utilizatori;
import org.example.aplicatie_trenuri.Repository.RezervareRepository;
import org.example.aplicatie_trenuri.Repository.TrenRepository;
import org.example.aplicatie_trenuri.Repository.UtilizatoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RezervareService {

    @Autowired
    private RezervareRepository rezervareRepository;

    @Autowired
    private TrenRepository trenRepository;

    @Autowired
    private UtilizatoriRepository utilizatoriRepository;

    @Autowired
    private EmailService emailService;

    public String adaugaRezervare(RezervareRequest request) {

        Tren tren = trenRepository.findById(request.getTrenId()).orElse(null);

        if (tren == null) {
            return "Tren inexistent";
        }

        Utilizatori utilizator =
                utilizatoriRepository.findById(request.getUtilizatorId()).orElse(null);

        if (utilizator == null) {
            return "Utilizator inexistent";
        }

        List<Rezervare> rezervari =
                rezervareRepository.findByTrenId(tren.getId());

        int locuriOcupate = 0;

        for (Rezervare rezervare : rezervari) {
            locuriOcupate += rezervare.getNumarBilete();
        }

        int locuriRamase =
                tren.getCapacitate() - locuriOcupate;

        if (request.getNumarBilete() > locuriRamase) {
            return "Nu mai sunt suficiente locuri";
        }

        Rezervare rezervare = new Rezervare();

        rezervare.setUtilizator(utilizator);
        rezervare.setTren(tren);
        rezervare.setEmailClient(request.getEmailClient());
        rezervare.setNumarBilete(request.getNumarBilete());

        rezervareRepository.save(rezervare);

        emailService.trimiteEmail(request.getEmailClient());

        return "Rezervare efectuata";
    }
}