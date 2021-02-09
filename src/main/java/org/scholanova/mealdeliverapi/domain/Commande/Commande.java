package org.scholanova.mealdeliverapi.domain.Commande;

import org.scholanova.mealdeliverapi.domain.Client;
import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;
import org.scholanova.mealdeliverapi.domain.Restaurant;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client", referencedColumnName = "id")
    Client client;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant", referencedColumnName = "id")
    Restaurant restaurant;
    @OneToMany
    List<ItemNourriture> contenu;
    @Column
    Date heureLivraison;
    @Column
    boolean couvertPlastique;
    @Enumerated(EnumType.STRING)
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

    public List<ItemNourriture> getContenu() {
        return contenu;
    }

    public void setContenu(List<ItemNourriture> contenu) {
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
