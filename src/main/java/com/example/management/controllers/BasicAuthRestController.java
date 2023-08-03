package com.example.management.controllers;
import com.example.management.entities.AuthenticationBean;
import com.example.management.entities.User;
import com.example.management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
public class BasicAuthRestController {

    @Autowired
    private UserService userService;

    /*

    public AuthenticationBean basicauth() {
        //On doit faire ici la vérification au niveau de la base de données avec la classe User
        return new AuthenticationBean("You are authenticated");
    }*/
    @GetMapping(path = "/basicauth")

    public User basicauth() {
        System.out.println("ok");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        System.out.println(user);

        return user;
    }


}