package com.projetOracle.GestionAssurance.repositories;

import java.util.List;

import com.projetOracle.GestionAssurance.entities.Client;
import com.projetOracle.GestionAssurance.entities.Contrat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")

public interface ContratRepository extends JpaRepository<Contrat, Long> {

    public List<Contrat> findByClient(Client client);

}
