package com.projetOracle.GestionAssurance.entities;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "cltproj", types = {Client.class})
public interface ClientProjection {
    public Long getId();
    public String getCin();
    public String getNom();
    // public String getPrenom();
    public String getAdresse();
    public Fonction getFonction();
    public String getStatus();
    public List<Contrat> getContrats();
}
