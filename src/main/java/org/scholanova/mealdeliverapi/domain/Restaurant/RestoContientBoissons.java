package org.scholanova.mealdeliverapi.domain.Restaurant;

import org.scholanova.mealdeliverapi.domain.Boisson;
import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;

import javax.persistence.*;

@Entity
public class RestoContientBoissons {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    Restaurant restaurant;

    @ManyToOne
    Boisson boisson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Boisson getBoisson() {
        return boisson;
    }

    public void setBoisson(Boisson boisson) {
        this.boisson = boisson;
    }

    public RestoContientBoissons(Restaurant restaurant, Boisson boisson) {
        this.restaurant = restaurant;
        this.boisson = boisson;
    }

    @Override
    public String toString() {
        return "RestoContientBoissons{" +
                "restaurant=" + restaurant +
                ", boisson=" + boisson +
                '}';
    }
}
