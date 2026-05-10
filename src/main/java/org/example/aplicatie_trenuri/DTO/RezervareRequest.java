package org.example.aplicatie_trenuri.DTO;

public class RezervareRequest {

    private Integer utilizatorId;

    private Integer trenId;

    private String emailClient;

    private Integer numarBilete;

    public Integer getUtilizatorId() {
        return utilizatorId;
    }

    public void setUtilizatorId(Integer utilizatorId) {
        this.utilizatorId = utilizatorId;
    }

    public Integer getTrenId() {
        return trenId;
    }

    public void setTrenId(Integer trenId) {
        this.trenId = trenId;
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