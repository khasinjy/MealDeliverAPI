package org.scholanova.mealdeliverapi.domain.Restaurant;

import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;

import javax.persistence.*;

@Entity
public class RestoContient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    Restaurant restaurant;

    @ManyToOne
    ItemNourriture nourriture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setNourriture(ItemNourriture nourriture) {
        this.nourriture = nourriture;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public ItemNourriture getNourriture() {
        return nourriture;
    }

    public RestoContient(Restaurant restaurant, ItemNourriture nourriture) {
        this.restaurant = restaurant;
        this.nourriture = nourriture;
    }

    public RestoContient() {
    }
}
