package org.example.aplicatie_trenuri.Service;

import org.example.aplicatie_trenuri.Model.Rezervare;
import org.example.aplicatie_trenuri.Model.Ruta;
import org.example.aplicatie_trenuri.Model.Tren;
import org.example.aplicatie_trenuri.Repository.RezervareRepository;
import org.example.aplicatie_trenuri.Repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomandareService {
//Partea aceasta de cod este facuta pentru Problema 2
    @Autowired
    private RutaRepository rutaRepository;

    @Autowired
    private RezervareRepository rezervareRepository;

    public String recomandaRuta(
            Integer statiePlecareId,
            Integer statieSosireId
    ) {

        List<Ruta> rute =
                rutaRepository.findByStatiePlecareIdAndStatieSosireId(
                        statiePlecareId,
                        statieSosireId
                );

        if (rute.isEmpty()) {
            return "Nu exista rute disponibile.";
        }

        Ruta ceaMaiBunaRuta = null;

        int scorMaxim = -999;

        for (Ruta ruta : rute) {

            Tren tren = ruta.getTren();

            List<Rezervare> rezervari =
                    rezervareRepository.findByTrenId(tren.getId());

            int locuriOcupate = 0;

            for (Rezervare rezervare : rezervari) {
                locuriOcupate += rezervare.getNumarBilete();
            }

            int locuriDisponibile =
                    tren.getCapacitate() - locuriOcupate;

            int scor =
                    locuriDisponibile - tren.getIntarziere();

            if (scor > scorMaxim) {

                scorMaxim = scor;

                ceaMaiBunaRuta = ruta;
            }
        }

        return
                "Cea mai buna ruta:\n" +
                        "Tren: " +
                        ceaMaiBunaRuta.getTren().getNumarTren() +
                        "\nPlecare: " +
                        ceaMaiBunaRuta.getStatiePlecare().getNume() +
                        "\nSosire: " +
                        ceaMaiBunaRuta.getStatieSosire().getNume() +
                        "\nOra plecare: " +
                        ceaMaiBunaRuta.getOraPlecare() +
                        "\nOra sosire: " +
                        ceaMaiBunaRuta.getOraSosire() +
                        "\nIntarziere: " +
                        ceaMaiBunaRuta.getTren().getIntarziere() +
                        " minute";
    }
}