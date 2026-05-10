package org.example.aplicatie_trenuri.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "trenuri")
public class Tren {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numar_tren")
    private String numarTren;

    private Integer capacitate;

    private Integer intarziere;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumarTren() {
        return numarTren;
    }

    public void setNumarTren(String numarTren) {
        this.numarTren = numarTren;
    }

    public Integer getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(Integer capacitate) {
        this.capacitate = capacitate;
    }

    public Integer getIntarziere() {
        return intarziere;
    }

    public void setIntarziere(Integer intarziere) {
        this.intarziere = intarziere;
    }
}