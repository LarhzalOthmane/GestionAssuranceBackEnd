package com.projetOracle.GestionAssurance.repositories;

import java.util.List;

import com.projetOracle.GestionAssurance.entities.Client;
import com.projetOracle.GestionAssurance.entities.ClientProjection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")

public interface ClientRepository extends JpaRepository<Client, Long> {

    public List<Client> findByNomContains(String nom);
    // public Page<ClientProjection> findByNomContains(String nom, Pageable page);
    // public Set<ClientProjection> findByNomContains(String nom);
}
