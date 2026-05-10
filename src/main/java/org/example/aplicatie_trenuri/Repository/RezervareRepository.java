package org.example.aplicatie_trenuri.Repository;

import org.example.aplicatie_trenuri.Model.Rezervare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RezervareRepository extends JpaRepository<Rezervare, Integer> {

    List<Rezervare> findByTrenId(Integer trenId);
}