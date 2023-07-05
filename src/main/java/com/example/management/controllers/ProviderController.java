package com.example.management.controllers;

import com.example.management.entities.Provider;
import com.example.management.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/providers"})
@CrossOrigin(origins = "*")
public class ProviderController {
    @Autowired
    private ProviderRepository providerRepository ;

    @GetMapping("/")
    public List<Provider> getAllProviders(){
       return (List<Provider>) providerRepository.findAll();
    }
    @PostMapping("/add")
    public Provider addProvider(@Valid @RequestBody Provider provider){
        return providerRepository.save(provider);
    }
@GetMapping("/{providerId}")
    public Provider getOneProvider(@PathVariable Long providerId){
    return  providerRepository.findById(providerId).orElseThrow(()->new IllegalArgumentException("provider id "+providerId+" not found "));
    }


    @PutMapping("/{providerId}")
    public Provider updateProvider(@RequestBody Provider provider, @PathVariable Long providerId){
        Provider updatedProvider=null;
        Optional<Provider>  opt=providerRepository.findById(providerId);
        if(opt.isPresent()){
            updatedProvider=opt.get();//object
            updatedProvider.setName(provider.getName());
            updatedProvider.setAddress(provider.getAddress());
            updatedProvider.setAddress(provider.getAddress());
            providerRepository.save(updatedProvider);

        }
        if(updatedProvider==null){
            throw new IllegalArgumentException("Provider not found");
        }
        return updatedProvider;
    }

     @DeleteMapping("/{providerId}")
    public Provider deleteProvider(@PathVariable Long providerId) {
         Optional<Provider> opt = providerRepository.findById(providerId);
         if (opt.isPresent()) {
             providerRepository.delete(opt.get());
         }
         if (opt.get() == null) {
             throw new IllegalArgumentException("provider not found");
         }
         return opt.get();
     }
}
