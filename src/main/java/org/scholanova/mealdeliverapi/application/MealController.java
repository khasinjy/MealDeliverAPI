package org.scholanova.mealdeliverapi.application;

import org.scholanova.mealdeliverapi.domain.Commande.Commande;
import org.scholanova.mealdeliverapi.domain.Commande.EtatCommande;
import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;
import org.scholanova.mealdeliverapi.domain.Menu;
import org.scholanova.mealdeliverapi.infrastructure.Commande.CommandeRepository;
import org.scholanova.mealdeliverapi.infrastructure.Menu.MenuRepository;
import org.scholanova.mealdeliverapi.infrastructure.Plat.repository.NourritureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MealController {

    @Autowired
    NourritureRepository nourritureRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    CommandeRepository commandeRepository;

    @GetMapping("/restaurant/carte")
    public Iterable<ItemNourriture> listMainCourses () {
        return nourritureRepository.findAll();

    }

    @GetMapping("/restaurant/menus")
    public Iterable<Menu> listMenus() {
        return menuRepository.findAll();
    }


    // Méthode Commande
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
