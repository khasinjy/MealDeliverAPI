package org.scholanova.mealdeliverapi.domain.Commande;

import java.util.List;

public interface CommandeService {

    List<Commande> getAllCommandesByRestaurant(String restaurant);

    List<Commande> getAllCommandes();

    void addCommande(Commande commande);
}
