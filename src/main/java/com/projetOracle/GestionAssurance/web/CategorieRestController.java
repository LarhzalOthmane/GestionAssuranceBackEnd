package com.projetOracle.GestionAssurance.web;

import javax.transaction.Transactional;

import com.projetOracle.GestionAssurance.entities.Categorie;
import com.projetOracle.GestionAssurance.repositories.CategorieRepository;

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
public class CategorieRestController {

    @Autowired
    CategorieRepository repository;

    @PutMapping("/editCategorie")
    @Transactional
    public String editCategorie(@RequestBody Categorie categorie) {
        String message = "Categorie updated!";
        repository.save(categorie);
        return message;
    }

    @PostMapping("/addCategorie")
    @Transactional
    public String addCategorie(@RequestBody Categorie categorie) {
        String message = "Categorie added!";
        repository.save(categorie);
        return message;
    }

    @DeleteMapping("/deleteCategorie")
    @Transactional
    public String deleteCategorie(@RequestParam Long id) {
        String message = "Categorie deleted!";
        repository.deleteById(id);
        return message;
    }

}
