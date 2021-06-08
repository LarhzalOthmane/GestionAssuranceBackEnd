package com.projetOracle.GestionAssurance.repositories;

import com.projetOracle.GestionAssurance.entities.Agence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin("*")
public interface AgenceRepository extends JpaRepository<Agence, Long> {
    
}
