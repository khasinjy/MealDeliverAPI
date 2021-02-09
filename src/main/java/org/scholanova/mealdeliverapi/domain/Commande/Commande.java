package org.scholanova.mealdeliverapi.domain.Commande;

import org.scholanova.mealdeliverapi.domain.Client;
import org.scholanova.mealdeliverapi.domain.ItemNourriture;
import org.scholanova.mealdeliverapi.domain.Restaurant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    Client client;
    @Column
    Restaurant restaurant;
    @Column
    ArrayList<ItemNourriture> contenu;
    @Column
    Date heureLivraison;
    @Column
    boolean couvertPlastique;
    @Column
    EtatCommande etat;

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

    public boolean isCouvertPlastique() {
        return couvertPlastique;
    }

    public void setCouvertPlastique(boolean couvertPlastique) {
        this.couvertPlastique = couvertPlastique;
    }

    public EtatCommande getEtat() {
        return etat;
    }

    public void setEtat(EtatCommande etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "client=" + client +
                ", restaurant=" + restaurant +
                ", contenu=" + contenu +
                ", heureLivraison=" + heureLivraison +
                ", couvertPlastique=" + couvertPlastique +
                ", etat=" + etat +
                '}';
    }
}
