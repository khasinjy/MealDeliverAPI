package org.scholanova.mealdeliverapi.domain.Commande;

import java.util.Date;
import java.util.List;

public class CommandePersistence {

    private Long restaurant;
    private Long client;
    private Long livreur;
    private List<Long> contenu;
    private List<Long> contenu_menu;
    private Date heureLivraison;
    private boolean couvertPlastique;

    public CommandePersistence() {
    }

    public Long getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Long restaurant) {
        this.restaurant = restaurant;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public Long getLivreur() {
        return livreur;
    }

    public void setLivreur(Long livreur) {
        this.livreur = livreur;
    }

    public List<Long> getContenu() {
        return contenu;
    }

    public void setContenu(List<Long> contenu) {
        this.contenu = contenu;
    }

    public List<Long> getContenu_menu() {
        return contenu_menu;
    }

    public void setContenu_menu(List<Long> contenu_menu) {
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

    @Override
    public String toString() {
        return "CommandePersistence{" +
                "restaurant=" + restaurant +
                ", client=" + client +
                ", livreur=" + livreur +
                ", contenu=" + contenu +
                ", contenu_menu=" + contenu_menu +
                ", heureLivraison=" + heureLivraison +
                ", couvertPlastique=" + couvertPlastique +
                '}';
    }
}
