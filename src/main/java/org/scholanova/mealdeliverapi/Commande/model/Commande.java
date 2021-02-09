package org.scholanova.mealdeliverapi.Commande.model;

import org.scholanova.mealdeliverapi.Client.model.Client;
import org.scholanova.mealdeliverapi.Nourriture.ItemNourriture.model.ItemNourriture;
import org.scholanova.mealdeliverapi.Restaurant.model.Restaurant;

import java.util.ArrayList;
import java.util.Date;

public class Commande {

    Client client;
    Restaurant restaurant;
    ArrayList<ItemNourriture> contenu;
    Date heureLivraison;
    boolean demandeCouvertPlastique;

    public Commande() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public ArrayList<ItemNourriture> getContenu() {
        return contenu;
    }

    public void setContenu(ArrayList<ItemNourriture> contenu) {
        this.contenu = contenu;
    }

    public Date getHeureLivraison() {
        return heureLivraison;
    }

    public void setHeureLivraison(Date heureLivraison) {
        this.heureLivraison = heureLivraison;
    }

    public boolean isDemandeCouvertPlastique() {
        return demandeCouvertPlastique;
    }

    public void setDemandeCouvertPlastique(boolean demandeCouvertPlastique) {
        this.demandeCouvertPlastique = demandeCouvertPlastique;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "client=" + client +
                ", restaurant=" + restaurant +
                ", contenu=" + contenu +
                ", heureLivraison=" + heureLivraison +
                ", demandeCouvertPlastique=" + demandeCouvertPlastique +
                '}';
    }
}
