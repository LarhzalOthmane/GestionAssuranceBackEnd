package com.projetOracle.GestionAssurance.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "conproj", types = {Contrat.class})
public interface ContratProjection {
    public Long getId();
    public String getMatricule();
    public Categorie getCategorie();
    public Agence getAgence();
    public Client getClient();
}
