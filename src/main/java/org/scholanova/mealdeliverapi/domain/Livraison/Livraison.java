package org.scholanova.mealdeliverapi.domain.Livraison;

import org.scholanova.mealdeliverapi.domain.Client;
import org.scholanova.mealdeliverapi.domain.Commande.Commande;
import org.scholanova.mealdeliverapi.domain.Livreur;
import org.scholanova.mealdeliverapi.domain.Restaurant.Restaurant;

import java.util.List;

public class Livraison {
    Livreur livreur;
    Restaurant restaurant;
    Client client;
    List<Commande> listeCommandes;
    EtatLivraison etat;

    public Livraison() {
    }

    public Livraison(Livreur livreur, Restaurant restaurant, Client client, List<Commande> listeCommandes) {
        this.livreur = livreur;
        this.restaurant = restaurant;
        this.client = client;
        this.listeCommandes = listeCommandes;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Commande> getListeCommandes() {
        return listeCommandes;
    }

    public void setListeCommandes(List<Commande> listeCommandes) {
        this.listeCommandes = listeCommandes;
    }

    public EtatLivraison getEtat() {
        return etat;
    }

    public void setEtat(EtatLivraison etat) {
        this.etat = etat;
    }


}
