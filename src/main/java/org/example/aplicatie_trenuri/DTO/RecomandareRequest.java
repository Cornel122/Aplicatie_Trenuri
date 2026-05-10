package org.example.aplicatie_trenuri.DTO;

public class RecomandareRequest {
//Partea aceasta de cod este facuta pentru Problema 2

    private Integer statiePlecareId;

    private Integer statieSosireId;

    public Integer getStatiePlecareId() {
        return statiePlecareId;
    }

    public void setStatiePlecareId(Integer statiePlecareId) {
        this.statiePlecareId = statiePlecareId;
    }

    public Integer getStatieSosireId() {
        return statieSosireId;
    }

    public void setStatieSosireId(Integer statieSosireId) {
        this.statieSosireId = statieSosireId;
    }
}