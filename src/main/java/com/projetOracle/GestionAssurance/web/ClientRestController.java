package com.projetOracle.GestionAssurance.web;

import javax.transaction.Transactional;

import com.projetOracle.GestionAssurance.entities.Client;
import com.projetOracle.GestionAssurance.repositories.ClientRepository;
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
public class ClientRestController {

    @Autowired
    ClientRepository repository;
    @Autowired
    FonctionRepository fonctionRepository;

    @PutMapping("/editClient")
    @Transactional
    public String editClient(@RequestBody Client client) {
        String message = "Client updated!";
        repository.save(client);
        return message;
    }

    @PostMapping("/addClient")
    @Transactional
    public String addClient(@RequestBody Client client) {
        String message = "Client added!";
        client.setFonction(fonctionRepository.getById(client.getFonction().getId()));
        repository.save(client);
        return message;
    }

    @DeleteMapping("/deleteClient")
    @Transactional
    public String deleteClient(@RequestParam Long id) {
        String message = "Client deleted!";
        repository.deleteById(id);
        return message;
    }

}
