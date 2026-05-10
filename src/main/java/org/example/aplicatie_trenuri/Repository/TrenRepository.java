package org.example.aplicatie_trenuri.Repository;

import org.example.aplicatie_trenuri.Model.Tren;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrenRepository extends JpaRepository<Tren, Integer> {
}