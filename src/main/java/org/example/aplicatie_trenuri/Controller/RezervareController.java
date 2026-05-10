package org.example.aplicatie_trenuri.Controller;

import org.example.aplicatie_trenuri.DTO.RezervareRequest;
import org.example.aplicatie_trenuri.Service.RezervareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/rezervari")
public class RezervareController {

    @Autowired
    private RezervareService rezervareService;

    @PostMapping
    public String adaugaRezervare(@RequestBody RezervareRequest request) {

        return rezervareService.adaugaRezervare(request);
    }
}