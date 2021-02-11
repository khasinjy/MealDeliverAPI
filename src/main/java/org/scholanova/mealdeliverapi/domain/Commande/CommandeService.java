package org.scholanova.mealdeliverapi.domain.Commande;

import org.scholanova.mealdeliverapi.domain.Restaurant;

import java.util.List;

public interface CommandeService {

    List<Commande> getAllCommandesByRestaurant(Restaurant restaurant);

    List<Commande> getAllCommandes();

    void addCommande(Commande commande);
}
