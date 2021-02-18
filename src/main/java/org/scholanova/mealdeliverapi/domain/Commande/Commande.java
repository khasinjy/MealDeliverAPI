package org.scholanova.mealdeliverapi.domain.Commande;

import org.scholanova.mealdeliverapi.domain.Client.Client;
import org.scholanova.mealdeliverapi.domain.Livreur.Livreur;
import org.scholanova.mealdeliverapi.domain.Menu.Menu;
import org.scholanova.mealdeliverapi.domain.Produit.Produit;
import org.scholanova.mealdeliverapi.domain.Restaurant.Restaurant;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Livreur livreur;

    @ManyToOne
    private Restaurant restaurant;

    @OneToMany
    private List<Produit> contenu;

    @OneToMany
    private List<Menu> contenu_menu;

    @Column
    private Date heureLivraison;

    @Column
    boolean couvertPlastique;

    @Enumerated(EnumType.STRING)
    private EtatCommande etat;


    public Commande() {
    }

    public Commande(Client client, Restaurant restaurant, List<Produit> contenu, List<Menu> contenu_menu, Date heureLivraison, boolean couvertPlastique) {
        this.client = client;
        this.restaurant = restaurant;
        this.contenu = contenu;
        this.contenu_menu = contenu_menu;
        this.heureLivraison = heureLivraison;
        this.couvertPlastique = couvertPlastique;
        this.etat = EtatCommande.EN_PREPARATION;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public List<Produit> getContenu() {
        return contenu;
    }

    public void setContenu(List<Produit> contenu) {
        this.contenu = contenu;
    }

    public List<Menu> getContenu_menu() {
        return contenu_menu;
    }

    public void setContenu_menu(List<Menu> contenu_menu) {
        this.contenu_menu = contenu_menu;
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
}
