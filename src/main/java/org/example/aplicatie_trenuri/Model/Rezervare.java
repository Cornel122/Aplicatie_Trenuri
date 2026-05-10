package org.example.aplicatie_trenuri.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "rezervari")
public class Rezervare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "utilizator_id")
    private Utilizatori utilizator;

    @ManyToOne
    @JoinColumn(name = "tren_id")
    private Tren tren;

    @Column(name = "email_client")
    private String emailClient;

    @Column(name = "numar_bilete")
    private Integer numarBilete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utilizatori getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(Utilizatori utilizator) {
        this.utilizator = utilizator;
    }

    public Tren getTren() {
        return tren;
    }

    public void setTren(Tren tren) {
        this.tren = tren;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public Integer getNumarBilete() {
        return numarBilete;
    }

    public void setNumarBilete(Integer numarBilete) {
        this.numarBilete = numarBilete;
    }
}