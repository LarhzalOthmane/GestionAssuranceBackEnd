package com.projetOracle.GestionAssurance.entities;

import java.util.Collection;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fnproj", types = { Fonction.class })
public interface FonctionProjection {
    public Long getId();
    public String getIntitule();
    public Collection<Client> getClients();
}
