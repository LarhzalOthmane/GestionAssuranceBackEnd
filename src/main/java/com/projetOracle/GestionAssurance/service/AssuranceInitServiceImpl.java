package com.projetOracle.GestionAssurance.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import com.projetOracle.GestionAssurance.entities.Agence;
import com.projetOracle.GestionAssurance.entities.Categorie;
import com.projetOracle.GestionAssurance.entities.Client;
import com.projetOracle.GestionAssurance.entities.Contrat;
import com.projetOracle.GestionAssurance.entities.Fonction;
import com.projetOracle.GestionAssurance.entities.Ville;
import com.projetOracle.GestionAssurance.repositories.AgenceRepository;
import com.projetOracle.GestionAssurance.repositories.CategorieRepository;
import com.projetOracle.GestionAssurance.repositories.ClientRepository;
import com.projetOracle.GestionAssurance.repositories.ContratRepository;
import com.projetOracle.GestionAssurance.repositories.FonctionRepository;
import com.projetOracle.GestionAssurance.repositories.VilleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AssuranceInitServiceImpl implements IAssuranceInitService {

    @Autowired
    private AgenceRepository agenceRepository;

    @Autowired

    private CategorieRepository categorieRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ContratRepository contratRepository;

    @Autowired
    private FonctionRepository fonctionRepository;

    @Autowired
    private VilleRepository villeRepository;

    @Override
    public void initAgences() {
        villeRepository.findAll().forEach(ville -> {
            Agence agence = new Agence();
            agence.setNom("Agence " + ville.getNom());
            agence.setAdresse("Appart. N°6, Imm. N°123, Bd. Idriss I");
            agence.setVille(ville);
            agenceRepository.save(agence);
        });
    }

    @Override
    public void initCategories() {
        Stream.of("Assurance vie", "Assurance décès", "Assurance maladie", "Garantie incapacité/invalidité de travail",
                "Garantie dépendance").forEach(categorieIntitule -> {
                    Categorie categorie = new Categorie();
                    categorie.setIntitule(categorieIntitule);
                    categorieRepository.save(categorie);
                });

    }

    @Override
    public void initClients() {
        String statuses[] = { "Marié", "Célibataire", "Divorcé", "Veuf" };
        fonctionRepository.findAll().forEach(fonction -> {
            Stream.of("Hamid Zrire9", "Hamid Lektef", "Titoss Larhzal").forEach(name -> {
                Client client = new Client();
                client.setCin(new Random().nextInt(1000) + "ABC");
                client.setNom(name);
                client.setStatus(statuses[new Random().nextInt(statuses.length)]);
                client.setAdresse("123, Lot. Nassim, Hay Zohor, Ouislane, 80050");
                client.setFonction(fonction);
                clientRepository.save(client);
            });
        });

    }

    @Override
    public void initContrats() {
        List<Client> clients = clientRepository.findAll();
        List<Categorie> categories = categorieRepository.findAll();
        agenceRepository.findAll().forEach(agence -> {
            Contrat contrat = new Contrat();
            contrat.setAgence(agence);
            contrat.setCategorie(categories.get(new Random().nextInt(categories.size())));
            contrat.setClient(clients.get(new Random().nextInt(clients.size())));
            contrat.setMatricule("666-9999-666/" + contrat.getClient().getNom());
            contratRepository.save(contrat);
        });

    }

    @Override
    public void initVilles() {
        Stream.of("Marrakech", "Casablanca", "Rabat", "Meknes", "Tanger").forEach(villeNom -> {
            Ville ville = new Ville();
            ville.setNom(villeNom);
            villeRepository.save(ville);
        });

    }

    @Override
    public void initFonctions() {
        Stream.of("Salarié", "Etudiant", "Sans emploi").forEach(fonctionIntitule -> {
            Fonction fonction = new Fonction();
            fonction.setIntitule(fonctionIntitule);
            fonctionRepository.save(fonction);
        });

    }

    public void truncate() {
        agenceRepository.deleteAll();

        categorieRepository.deleteAll();

        clientRepository.deleteAll();

        contratRepository.deleteAll();

        fonctionRepository.deleteAll();

        villeRepository.deleteAll();

    }

}
