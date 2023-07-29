package com.example.management.services;


import com.example.management.entities.Role;
import com.example.management.entities.User;
import com.example.management.repositories.RoleRepository;
import com.example.management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;


@Service("userService")
public class UserService {



    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,//DE JPA
                       RoleRepository roleRepository,//DE JPA
                       BCryptPasswordEncoder bCryptPasswordEncoder // DE Bean
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);

    }
    public void saveUser(User user) {
        System.out.println("save begin");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(0);
        Role userRole=roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);


    }
}
