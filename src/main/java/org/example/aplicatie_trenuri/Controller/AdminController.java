package org.example.aplicatie_trenuri.Controller;

import org.example.aplicatie_trenuri.Model.Rezervare;
import org.example.aplicatie_trenuri.Model.Ruta;
import org.example.aplicatie_trenuri.Model.Tren;
import org.example.aplicatie_trenuri.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/trenuri")
    public Tren adaugaTren(@RequestBody Tren tren) {
        return adminService.adaugaTren(tren);
    }

    @PutMapping("/trenuri/{id}")
    public Tren modificaTren(@PathVariable Integer id, @RequestBody Tren tren) {
        return adminService.modificaTren(id, tren);
    }

    @DeleteMapping("/trenuri/{id}")
    public String stergeTren(@PathVariable Integer id) {
        return adminService.stergeTren(id);
    }

    @PostMapping("/rute")
    public Ruta adaugaRuta(@RequestBody Ruta ruta) {
        return adminService.adaugaRuta(ruta);
    }

    @PutMapping("/rute/{id}")
    public Ruta modificaRuta(@PathVariable Integer id, @RequestBody Ruta ruta) {
        return adminService.modificaRuta(id, ruta);
    }

    @DeleteMapping("/rute/{id}")
    public String stergeRuta(@PathVariable Integer id) {
        return adminService.stergeRuta(id);
    }

    @GetMapping("/trenuri/{trenId}/rezervari")
    public List<Rezervare> rezervariPentruTren(@PathVariable Integer trenId) {
        return adminService.rezervariPentruTren(trenId);
    }

    @PutMapping("/trenuri/{trenId}/intarziere")
    public String adaugaIntarziere(
            @PathVariable Integer trenId,
            @RequestParam Integer minute
    ) {
        return adminService.adaugaIntarziere(trenId, minute);
    }
    @GetMapping("/rute")
    public List<Ruta> toateRutele() {
        return adminService.toateRutele();
    }
}