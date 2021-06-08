package com.projetOracle.GestionAssurance.web;

import javax.transaction.Transactional;

import com.projetOracle.GestionAssurance.entities.Ville;
import com.projetOracle.GestionAssurance.repositories.VilleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class VilleRestController {

    @Autowired
    VilleRepository repository;

    @PutMapping("/editVille")
    @Transactional
    public String editVille(@RequestBody Ville ville) {
        String message = "Ville updated!";
        repository.save(ville);
        return message;
    }

    @PostMapping("/addVille")
    @Transactional
    public String addVille(@RequestBody Ville ville) {
        String message = "Ville added!";
        repository.save(ville);
        return message;
    }

    @DeleteMapping("/deleteVille")
    @Transactional
    public String deleteVille(@RequestParam Long id) {
        String message = "Ville deleted!";
        repository.deleteById(id);
        return message;
    }

}
