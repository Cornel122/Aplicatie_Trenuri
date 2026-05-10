package org.example.aplicatie_trenuri.Repository;

import org.example.aplicatie_trenuri.Model.Utilizatori;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilizatoriRepository extends JpaRepository<Utilizatori, Integer> {

    Utilizatori findByNume(String nume);

}