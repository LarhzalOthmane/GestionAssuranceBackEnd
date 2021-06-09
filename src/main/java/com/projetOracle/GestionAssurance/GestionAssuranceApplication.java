package com.projetOracle.GestionAssurance;


import com.projetOracle.GestionAssurance.entities.Agence;
import com.projetOracle.GestionAssurance.entities.Categorie;
import com.projetOracle.GestionAssurance.entities.Contrat;
import com.projetOracle.GestionAssurance.entities.Fonction;
import com.projetOracle.GestionAssurance.entities.Ville;
import com.projetOracle.GestionAssurance.service.IAssuranceInitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import ch.qos.logback.core.net.server.Client;

@SpringBootApplication
public class GestionAssuranceApplication implements CommandLineRunner {

	@Autowired
	private IAssuranceInitService initService;
	@Autowired
	private RepositoryRestConfiguration configuration;

	public static void main(String[] args) {
		SpringApplication.run(GestionAssuranceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application started!");
		configuration.exposeIdsFor(Agence.class, Categorie.class, Client.class, Contrat.class, Fonction.class,
				Ville.class);
		// initService.truncate();
		initService.initVilles();
		initService.initAgences();
		initService.initCategories();
		initService.initFonctions();
		initService.initClients();
		initService.initContrats();
	}

	
}
