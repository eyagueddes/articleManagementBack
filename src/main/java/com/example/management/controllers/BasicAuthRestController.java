package com.example.management.controllers;
import com.example.management.entities.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController


public class BasicAuthRestController {

    @GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        //doit faire verification au niveau de la base de données
        return new AuthenticationBean("You are authenticated");
    }

}
