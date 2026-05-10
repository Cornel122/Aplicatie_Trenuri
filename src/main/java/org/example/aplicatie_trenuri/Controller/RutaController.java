package org.example.aplicatie_trenuri.Controller;

import org.example.aplicatie_trenuri.DTO.RutaRequest;
import org.example.aplicatie_trenuri.Service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/rute")
public class RutaController {

    @Autowired
    private RutaService rutaService;

    @PostMapping("/cauta")
    public String cautaRuta(
            @RequestBody RutaRequest request
    ) {

        return rutaService.cautaRuta(
                request.getStatiePlecareId(),
                request.getStatieSosireId()
        );
    }
}