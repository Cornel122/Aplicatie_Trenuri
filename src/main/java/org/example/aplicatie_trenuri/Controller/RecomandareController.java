package org.example.aplicatie_trenuri.Controller;

import org.example.aplicatie_trenuri.DTO.RecomandareRequest;
import org.example.aplicatie_trenuri.Service.RecomandareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recomandare")
@CrossOrigin(origins = "http://localhost:5173")
public class RecomandareController {
//Partea aceasta de cod este facuta pentru Problema 2

    @Autowired
    private RecomandareService recomandareService;

    @PostMapping
    public String recomandare(
            @RequestBody RecomandareRequest request
    ) {

        return recomandareService.recomandaRuta(
                request.getStatiePlecareId(),
                request.getStatieSosireId()
        );
    }
}