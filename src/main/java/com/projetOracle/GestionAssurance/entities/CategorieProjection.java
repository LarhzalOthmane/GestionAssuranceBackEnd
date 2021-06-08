package com.projetOracle.GestionAssurance.entities;

import java.util.Collection;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "catproj", types = {Categorie.class})
public interface CategorieProjection {
    public Long getId();

    public String getIntitule();

    public Collection<Contrat> getContrats();
}
