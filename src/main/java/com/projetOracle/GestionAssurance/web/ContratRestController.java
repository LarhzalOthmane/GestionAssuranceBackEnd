package com.projetOracle.GestionAssurance.web;

import javax.transaction.Transactional;

import com.projetOracle.GestionAssurance.entities.Contrat;
import com.projetOracle.GestionAssurance.repositories.AgenceRepository;
import com.projetOracle.GestionAssurance.repositories.CategorieRepository;
import com.projetOracle.GestionAssurance.repositories.ClientRepository;
import com.projetOracle.GestionAssurance.repositories.ContratRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ContratRestController {

    @Autowired
    ContratRepository repository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CategorieRepository categorieRepository;
    @Autowired
    AgenceRepository agenceRepository;

    @PutMapping("/editContrat")
    @Transactional
    public String editContrat(@RequestBody Contrat contrat) {
        String message = "Contrat updated!";
        repository.save(contrat);
        return message;
    }

    @PostMapping("/addContrat")
    @Transactional
    public String addContrat(@RequestBody Contrat contrat) {
        String message = "Contrat added!";
        contrat.setAgence(agenceRepository.getById(contrat.getAgence().getId()));
        contrat.setClient(clientRepository.getById(contrat.getClient().getId()));
        contrat.setCategorie(categorieRepository.getById(contrat.getCategorie().getId()));
        repository.save(contrat);
        return message;
    }

    @DeleteMapping("/deleteContrat")
    @Transactional
    public String deleteContrat(@RequestParam Long id) {
        String message = "Contrat deleted!";
        repository.deleteById(id);
        return message;
    }

}
