package org.example.aplicatie_trenuri.Controller;

import org.example.aplicatie_trenuri.Model.Tren;
import org.example.aplicatie_trenuri.Repository.TrenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/trenuri")
public class TrenController {

    @Autowired
    private TrenRepository trenRepository;

    @GetMapping
    public List<Tren> getTrenuri() {
        return trenRepository.findAll();
    }
}