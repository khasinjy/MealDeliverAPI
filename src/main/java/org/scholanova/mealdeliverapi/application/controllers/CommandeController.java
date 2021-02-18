package org.scholanova.mealdeliverapi.application.controllers;

import org.scholanova.mealdeliverapi.domain.Client.Client;
import org.scholanova.mealdeliverapi.domain.Client.ClientNonTrouveException;
import org.scholanova.mealdeliverapi.domain.Commande.*;
import org.scholanova.mealdeliverapi.domain.Livreur.Livreur;
import org.scholanova.mealdeliverapi.domain.Livreur.Exception.LivreurDejaEnRouteException;
import org.scholanova.mealdeliverapi.domain.Livreur.Exception.LivreurNonTrouveException;
import org.scholanova.mealdeliverapi.domain.Menu.Menu;
import org.scholanova.mealdeliverapi.domain.Produit.Produit;
import org.scholanova.mealdeliverapi.domain.Restaurant.Exception.RestaurantNonTrouveException;
import org.scholanova.mealdeliverapi.domain.Restaurant.Restaurant;
import org.scholanova.mealdeliverapi.infrastructure.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CommandeController {

    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    LivreurRepository livreurRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @GetMapping("/commandes")
    public Iterable<Commande> listCommandes() {
        return commandeRepository.findAll();
    }

    @PostMapping("/addCommande")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCommande(@RequestBody CommandePersistence commande) {

        Client client = clientRepository.findById(commande.getClient()).get();
        if(client == null){
            throw new ClientNonTrouveException("Le client avec l'id " + commande.getClient() + " n'existe pas.");
        }

        Restaurant restaurant = restaurantRepository.findById(commande.getRestaurant()).get();
        if(restaurant == null){
            throw new RestaurantNonTrouveException("Le restaurant avec l'id " + commande.getRestaurant() + " n'existe pas.");
        }

        List<Long> id_contenu = commande.getContenu();
        List<Long> id_contenu_menu = commande.getContenu_menu();
        List<Produit> contenu = null;
        List<Menu> contenu_menu = null;
        if(id_contenu == null && id_contenu_menu == null){
            throw new CommandeVideException("Le contenu de la commande n'est pas précisé.");
        } else if(id_contenu != null) {
            contenu = id_contenu.stream()
                    .map(c -> produitRepository.findById(c).orElse(null))
                    .collect(Collectors.toList());
        }else {
            contenu_menu = id_contenu_menu.stream()
                    .map(c -> menuRepository.findById(c).orElse(null))
                    .collect(Collectors.toList());
        }
        Date heureLivraison  = commande.getHeureLivraison();

        boolean couvertPlastique = commande.isCouvertPlastique();

        Commande newCommande = new Commande(client, restaurant, contenu, contenu_menu, heureLivraison, couvertPlastique);

        commandeRepository.save(newCommande);

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

    @PutMapping("/commande/{id}/{etat}")
    public String changementEtatCommande(@PathVariable Long id, @PathVariable EtatCommande etat){

        Commande commande = commandeRepository.findById(id).get();
        if(commande == null){ throw new CommandeNonTrouveeException("La commande " + id + " n'existe pas.");}
        commande.setEtat(etat);
        commandeRepository.save(commande);
        return "La commande avec l'id " + id + "est " + etat;
    }

    @PutMapping("/commande/{id_commande}/livreur/{id_livreur}")
    public String attributionCommandeAlivreur(@PathVariable Long id_commande, @PathVariable Long id_livreur){

        Commande commande = commandeRepository.findById(id_commande).get();
        if(commande == null){ throw new CommandeNonTrouveeException("La commande " + id_commande + " n'existe pas.");}

        if(commande.getEtat() == EtatCommande.EN_CHEMIN){
            throw new LivreurDejaEnRouteException("La commande " + id_commande + " est déjà en chemin.");}

        Livreur livreur = livreurRepository.findById(id_livreur).get();
        if(livreur == null){ throw new LivreurNonTrouveException("Le livreur " + id_livreur + " n'est pas disponible.");}

        commande.setLivreur(livreur);
        commande.setEtat(EtatCommande.EN_CHEMIN);
        commandeRepository.save(commande);
        return "La commande avec l'id " + id_commande + " est en chemin. \nLe livreur " +
                livreur.getPrenom() + " vous l'apporte.";
    }
}
