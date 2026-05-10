package org.example.aplicatie_trenuri.Service;

import org.example.aplicatie_trenuri.Model.Ruta;
import org.example.aplicatie_trenuri.Repository.RutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    public String cautaRuta(Integer plecareId, Integer sosireId) {

        List<Ruta> directe =
                rutaRepository.findByStatiePlecareIdAndStatieSosireId(
                        plecareId,
                        sosireId
                );

        if (!directe.isEmpty()) {

            Ruta ruta = directe.get(0);

            return "Ruta directa gasita\n"
                    + "Tren: " + ruta.getTren().getNumarTren() + "\n"
                    + "Plecare din: " + ruta.getStatiePlecare().getNume() + "\n"
                    + "Sosire in: " + ruta.getStatieSosire().getNume() + "\n"
                    + "Ora plecare: " + ruta.getOraPlecare() + "\n"
                    + "Ora sosire: " + ruta.getOraSosire();
        }

        List<Ruta> plecari =
                rutaRepository.findByStatiePlecareId(plecareId);

        List<Ruta> sosiri =
                rutaRepository.findByStatieSosireId(sosireId);

        for (Ruta r1 : plecari) {

            for (Ruta r2 : sosiri) {

                if (r1.getStatieSosire().getId()
                        .equals(r2.getStatiePlecare().getId())) {

                    return "Ruta cu schimbare gasita\n"
                            + "Schimbare in: " + r1.getStatieSosire().getNume() + "\n\n"

                            + "Primul tren: " + r1.getTren().getNumarTren() + "\n"
                            + "Plecare din: " + r1.getStatiePlecare().getNume() + "\n"
                            + "Sosire in: " + r1.getStatieSosire().getNume() + "\n"
                            + "Ora plecare: " + r1.getOraPlecare() + "\n"
                            + "Ora sosire: " + r1.getOraSosire() + "\n\n"

                            + "Al doilea tren: " + r2.getTren().getNumarTren() + "\n"
                            + "Plecare din: " + r2.getStatiePlecare().getNume() + "\n"
                            + "Sosire in: " + r2.getStatieSosire().getNume() + "\n"
                            + "Ora plecare: " + r2.getOraPlecare() + "\n"
                            + "Ora sosire: " + r2.getOraSosire();
                }
            }
        }

        return "Nu exista legatura intre statii";
    }
}