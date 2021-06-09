package com.projetOracle.GestionAssurance.web;

import javax.transaction.Transactional;

import com.projetOracle.GestionAssurance.entities.Agence;
import com.projetOracle.GestionAssurance.repositories.AgenceRepository;
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
public class AgenceRestController {

    @Autowired
    AgenceRepository repository;
    @Autowired
    VilleRepository villeRepository;

    @PutMapping("/editAgence")
    @Transactional
    public String editAgence(@RequestBody Agence agence) {
        String message = "Agence updated!";
        repository.save(agence);
        return message;
    }

    @PostMapping("/addAgence")
    @Transactional
    public String addAgence(@RequestBody Agence agence) {
        String message = "Agence added!";
        agence.setVille(villeRepository.getById(agence.getVille().getId()));
        repository.save(agence);
        return message;
    }

    @DeleteMapping("/deleteAgence")
    @Transactional
    public String deleteAgence(@RequestParam Long id) {
        String message = "Agence deleted!";
        repository.deleteById(id);
        return message;
    }
    
}
