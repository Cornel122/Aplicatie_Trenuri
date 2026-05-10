package org.example.aplicatie_trenuri.Controller;

import org.example.aplicatie_trenuri.Model.Statie;
import org.example.aplicatie_trenuri.Repository.StatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/statii")
public class StatieController {

    @Autowired
    private StatieRepository statieRepository;

    @GetMapping
    public List<Statie> getStatii() {
        return statieRepository.findAll();
    }
}