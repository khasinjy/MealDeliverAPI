package org.scholanova.mealdeliverapi.domain.Restaurant;

import org.scholanova.mealdeliverapi.domain.Produit.Produit;

import javax.persistence.*;

@Entity
public class RestoContient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    Restaurant restaurant;

    @ManyToOne
    Produit produit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Produit getProduit() {
        return produit;
    }

    public RestoContient(Restaurant restaurant, Produit produit) {
        this.restaurant = restaurant;
        this.produit = produit;
    }

    public RestoContient() {
    }
}
