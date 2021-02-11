package org.scholanova.mealdeliverapi.application;

import org.scholanova.mealdeliverapi.domain.Commande.Commande;
import org.scholanova.mealdeliverapi.infrastructure.Commande.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommandeController {
    @Autowired
    CommandeRepository commandeRepository;

    @GetMapping("/commandes")
    public Iterable<Commande> listCommandes() {
        return commandeRepository.findAll();
    }


    @GetMapping("/commandes/{etat}")
    public List<Commande> listCommandesByEtat(@PathVariable("etat") String etatCommande) {
        List<Commande> commandes = new ArrayList<Commande>();
        for (Commande uneCommande : commandeRepository.findAll()) {
            if (uneCommande.getEtat().toString().equals(etatCommande)) {
                commandes.add(uneCommande);
            }
        }
        return commandes;
    }
}
