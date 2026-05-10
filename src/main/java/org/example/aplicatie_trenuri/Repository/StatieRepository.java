package org.example.aplicatie_trenuri.Repository;

import org.example.aplicatie_trenuri.Model.Statie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatieRepository extends JpaRepository<Statie, Integer> {
}