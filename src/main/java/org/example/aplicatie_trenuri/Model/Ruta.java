package org.example.aplicatie_trenuri.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "rute")
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tren_id")
    private Tren tren;

    @ManyToOne
    @JoinColumn(name = "statie_plecare_id")
    private Statie statiePlecare;

    @ManyToOne
    @JoinColumn(name = "statie_sosire_id")
    private Statie statieSosire;

    @Column(name = "ora_plecare")
    private String oraPlecare;

    @Column(name = "ora_sosire")
    private String oraSosire;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tren getTren() {
        return tren;
    }

    public void setTren(Tren tren) {
        this.tren = tren;
    }

    public Statie getStatiePlecare() {
        return statiePlecare;
    }

    public void setStatiePlecare(Statie statiePlecare) {
        this.statiePlecare = statiePlecare;
    }

    public Statie getStatieSosire() {
        return statieSosire;
    }

    public void setStatieSosire(Statie statieSosire) {
        this.statieSosire = statieSosire;
    }

    public String getOraPlecare() {
        return oraPlecare;
    }

    public void setOraPlecare(String oraPlecare) {
        this.oraPlecare = oraPlecare;
    }

    public String getOraSosire() {
        return oraSosire;
    }

    public void setOraSosire(String oraSosire) {
        this.oraSosire = oraSosire;
    }
}