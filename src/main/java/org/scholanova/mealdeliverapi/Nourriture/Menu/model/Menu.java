package org.scholanova.mealdeliverapi.Nourriture.Menu.model;

import org.scholanova.mealdeliverapi.Nourriture.Boisson.model.Boisson;
import org.scholanova.mealdeliverapi.Nourriture.ItemNourriture.model.ItemNourriture;

import java.util.List;

public class Menu {

    ItemNourriture entree;
    ItemNourriture plat;
    ItemNourriture dessert;
    Boisson boisson;
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
