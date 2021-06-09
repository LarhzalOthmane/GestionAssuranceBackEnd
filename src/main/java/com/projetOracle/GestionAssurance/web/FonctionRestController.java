package com.projetOracle.GestionAssurance.web;

import javax.transaction.Transactional;

import com.projetOracle.GestionAssurance.entities.Fonction;
import com.projetOracle.GestionAssurance.repositories.FonctionRepository;

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
public class FonctionRestController {

    @Autowired
    FonctionRepository repository;

    @PutMapping("/editFonction")
    @Transactional
    public String editFonction(@RequestBody Fonction fonction) {
        String message = "Fonction updated!";
        repository.save(fonction);
        return message;
    }

    @PostMapping("/addFonction")
    @Transactional
    public String addFonction(@RequestBody Fonction fonction) {
        String message = "Fonction added!";
        repository.save(fonction);
        return message;
    }

    @DeleteMapping("/deleteFonction")
    @Transactional
    public String deleteFonction(@RequestParam Long id) {
        String message = "Fonction deleted!";
        repository.deleteById(id);
        return message;
    }

}
