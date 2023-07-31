package com.example.management.controllers;

import com.example.management.entities.Role;
import com.example.management.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role/")
public class RoleController {
private final RoleRepository roleRepository;



   @Autowired
    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("/list")
    public String listRoles(Model model){
       List<Role> roles=roleRepository.findAll();
       long nb=roleRepository.count();
       if(roles.size()==0)
           roles=null;
       model.addAttribute("roles",roles);
       model.addAttribute("nb",nb);
       return "role/listRoles";

    }
    @PostMapping("add")
    public Map addRole(@RequestParam("role") String role){
        Map<String,String> res=new HashMap<>();
       Role r=new Role(role);
       Role roleExist=null;
       roleExist=roleRepository.findByRole(role);
       if(roleExist==null)
       {
           Role rSaved=roleRepository.save(r);


       }
       else{
           System.out.println("role exist deja");

       }

        res.put("role",role);
        return  res;

    }
}
