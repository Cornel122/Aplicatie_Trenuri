package org.example.aplicatie_trenuri.Controller;
import org.example.aplicatie_trenuri.Model.Utilizatori;
import org.example.aplicatie_trenuri.DTO.LoginRequest;
import org.example.aplicatie_trenuri.DTO.SignupRequest;
import org.example.aplicatie_trenuri.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest request) {

        return authService.signup(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        return authService.login(request);
    }
    @GetMapping("/utilizator/{nume}")
    public Utilizatori getUtilizator(@PathVariable String nume) {

        return authService.getUtilizator(nume);
    }
}