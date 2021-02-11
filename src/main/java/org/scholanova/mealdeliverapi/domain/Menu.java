package org.scholanova.mealdeliverapi.domain;

import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;

import javax.persistence.*;

@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ItemNourriture entree;

    @ManyToOne
    private ItemNourriture plat;

    @ManyToOne
    private ItemNourriture dessert;

    @ManyToOne
    private Boisson boisson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemNourriture getEntree() {
        return entree;
    }

    public void setEntree(ItemNourriture entree) {
        this.entree = entree;
    }

    public ItemNourriture getPlat() {
        return plat;
    }

    public void setPlat(ItemNourriture plat) {
        this.plat = plat;
    }

    public ItemNourriture getDessert() {
        return dessert;
    }

    public void setDessert(ItemNourriture dessert) {
        this.dessert = dessert;
    }

    public Boisson getBoisson() {
        return boisson;
    }

    public void setBoisson(Boisson boisson) {
        this.boisson = boisson;
    }

    public Menu() {
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", entree=" + entree +
                ", plat=" + plat +
                ", dessert=" + dessert +
                ", boisson=" + boisson +
                '}';
    }
}
