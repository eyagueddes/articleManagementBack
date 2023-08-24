package com.example.management.controllers;
import com.example.management.entities.User;
import com.example.management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController()
@RequestMapping("/auth")
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

        System.out.println("hello from");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("heeeeeeeeeee");
        System.out.println(auth);
        //  String currentUserName = null;
        User user = null;
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            //   currentUserName = (User) authentication.getPrincipal();
            user = userService.findUserByEmail(auth.getName());

            System.out.println("user" + user);
            return user;

        } else {
            throw new RuntimeException("No User");
            //System.out.println(currentUserName+auth.getName());
        }
    }

    @GetMapping("/test")
    public String test(){
        System.out.println("hello from before");
        return "hello from the app";
    }


}