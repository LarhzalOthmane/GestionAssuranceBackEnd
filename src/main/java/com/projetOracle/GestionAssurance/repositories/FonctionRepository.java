package com.projetOracle.GestionAssurance.repositories;

import com.projetOracle.GestionAssurance.entities.Fonction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")

public interface FonctionRepository extends JpaRepository<Fonction, Long> {

}
