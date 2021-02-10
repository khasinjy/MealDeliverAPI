package org.scholanova.mealdeliverapi.domain;

import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;

import javax.persistence.*;
import java.util.List;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entree", referencedColumnName = "id")
    ItemNourriture entree;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plat", referencedColumnName = "id")
    ItemNourriture plat;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dessert", referencedColumnName = "id")
    ItemNourriture dessert;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "boisson", referencedColumnName = "id")
    Boisson boisson;
    @OneToMany
    List<ItemNourriture> supplement;

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

    public List<ItemNourriture> getSupplement() {
        return supplement;
    }

    public void setSupplement(List<ItemNourriture> supplement) {
        this.supplement = supplement;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "entree=" + entree +
                ", plat=" + plat +
                ", dessert=" + dessert +
                ", boisson=" + boisson +
                ", supplement=" + supplement +
                '}';
    }
}
