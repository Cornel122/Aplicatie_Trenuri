package org.example.aplicatie_trenuri.Repository;

import org.example.aplicatie_trenuri.Model.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RutaRepository extends JpaRepository<Ruta, Integer> {

    List<Ruta> findByStatiePlecareIdAndStatieSosireId(Integer plecareId, Integer sosireId);

    List<Ruta> findByStatiePlecareId(Integer plecareId);

    List<Ruta> findByStatieSosireId(Integer sosireId);
}