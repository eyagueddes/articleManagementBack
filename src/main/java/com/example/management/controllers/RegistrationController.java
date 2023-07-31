package com.example.management.controllers;

import com.example.management.entities.Role;
import com.example.management.entities.User;
import com.example.management.repositories.RoleRepository;
import com.example.management.services.UserService;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
@RestController
@CrossOrigin(origins = "*")
public class RegistrationController {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;

    @RequestMapping(value="/registration",method = RequestMethod.POST)
    public User createNewUser(@RequestBody User user){
        System.out.println("uiser");
        System.out.println(user);
        Role userRole=roleRepository.findByRole(user.getTemp());//role temporaire
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
            userService.saveUser(user);
        return user;
    }

}
