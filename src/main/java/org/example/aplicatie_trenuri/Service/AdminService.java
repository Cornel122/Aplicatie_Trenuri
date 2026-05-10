package org.example.aplicatie_trenuri.Service;

import org.example.aplicatie_trenuri.Model.Rezervare;
import org.example.aplicatie_trenuri.Model.Ruta;
import org.example.aplicatie_trenuri.Model.Statie;
import org.example.aplicatie_trenuri.Model.Tren;
import org.example.aplicatie_trenuri.Repository.RezervareRepository;
import org.example.aplicatie_trenuri.Repository.RutaRepository;
import org.example.aplicatie_trenuri.Repository.StatieRepository;
import org.example.aplicatie_trenuri.Repository.TrenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private TrenRepository trenRepository;

    @Autowired
    private RutaRepository rutaRepository;

    @Autowired
    private StatieRepository statieRepository;

    @Autowired
    private RezervareRepository rezervareRepository;

    @Autowired
    private EmailService emailService;

    public Tren adaugaTren(Tren tren) {
        return trenRepository.save(tren);
    }

    public String stergeTren(Integer id) {
        trenRepository.deleteById(id);
        return "Tren sters";
    }

    public Tren modificaTren(Integer id, Tren trenNou) {
        Tren tren = trenRepository.findById(id).orElse(null);

        if (tren == null) {
            return null;
        }

        tren.setNumarTren(trenNou.getNumarTren());
        tren.setCapacitate(trenNou.getCapacitate());
        tren.setIntarziere(trenNou.getIntarziere());

        return trenRepository.save(tren);
    }

    public Ruta adaugaRuta(Ruta ruta) {
        return rutaRepository.save(ruta);
    }

    public String stergeRuta(Integer id) {
        rutaRepository.deleteById(id);
        return "Ruta stearsa";
    }

    public Ruta modificaRuta(Integer id, Ruta rutaNoua) {
        Ruta ruta = rutaRepository.findById(id).orElse(null);

        if (ruta == null) {
            return null;
        }

        ruta.setTren(rutaNoua.getTren());
        ruta.setStatiePlecare(rutaNoua.getStatiePlecare());
        ruta.setStatieSosire(rutaNoua.getStatieSosire());
        ruta.setOraPlecare(rutaNoua.getOraPlecare());
        ruta.setOraSosire(rutaNoua.getOraSosire());

        return rutaRepository.save(ruta);
    }

    public List<Rezervare> rezervariPentruTren(Integer trenId) {
        return rezervareRepository.findByTrenId(trenId);
    }

    public String adaugaIntarziere(Integer trenId, Integer minute) {
        Tren tren = trenRepository.findById(trenId).orElse(null);

        if (tren == null) {
            return "Tren inexistent";
        }

        tren.setIntarziere(minute);
        trenRepository.save(tren);

        List<Rezervare> rezervari = rezervareRepository.findByTrenId(trenId);

        for (Rezervare rezervare : rezervari) {
            emailService.trimiteEmail(
                    rezervare.getEmailClient(),
                    "Tren intarziat",
                    "Trenul " + tren.getNumarTren() + " are intarziere de " + minute + " minute."
            );
        }

        return "Intarziere salvata si clientii au fost notificati";
    }
    public List<Ruta> toateRutele() {
        return rutaRepository.findAll();
    }
}