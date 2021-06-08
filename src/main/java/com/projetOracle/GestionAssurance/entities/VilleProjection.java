package com.projetOracle.GestionAssurance.entities;

import java.util.Collection;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "vproj", types = {Ville.class})
public interface VilleProjection {
    public Long getId();
    public String getNom();
    public Collection<Agence> getAgences();
}
