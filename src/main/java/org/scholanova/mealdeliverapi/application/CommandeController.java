package org.scholanova.mealdeliverapi.application;

import org.scholanova.mealdeliverapi.domain.Commande.Commande;
import org.scholanova.mealdeliverapi.domain.Commande.CommandeService;
import org.scholanova.mealdeliverapi.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    CommandeService commandeService;

    @GetMapping
    @ResponseBody
    public List<Commande> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @GetMapping
    @ResponseBody
    List<Commande> getAllCommandesByRestaurant(Restaurant restaurant) { return commandeService.getAllCommandesByRestaurant(restaurant); }

    @GetMapping
    @ResponseBody
    public void addCommande(Commande commande) throws ParseException { commandeService.addCommande(commande); }

}
