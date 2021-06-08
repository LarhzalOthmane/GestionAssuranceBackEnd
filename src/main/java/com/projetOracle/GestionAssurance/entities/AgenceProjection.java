package com.projetOracle.GestionAssurance.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "agproj", types = {Agence.class})
public interface AgenceProjection {
    public Long getId();
    public String getNom();
    public String getAdresse();
    public Ville getVille();
}
