package com.projetOracle.GestionAssurance.service;

public interface IAssuranceInitService {
    public void initAgences();

    public void initCategories();

    public void initClients();

    public void initContrats();

    public void initVilles();

    public void initFonctions();

    public void truncate();
}
