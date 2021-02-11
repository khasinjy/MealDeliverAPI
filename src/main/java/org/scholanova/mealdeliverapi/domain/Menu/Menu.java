package org.scholanova.mealdeliverapi.domain.Menu;

import org.scholanova.mealdeliverapi.domain.Boisson;
import org.scholanova.mealdeliverapi.domain.ItemNourriture.ItemNourriture;
import org.scholanova.mealdeliverapi.domain.ItemNourriture.TypeNourriture;
import org.scholanova.mealdeliverapi.domain.Menu.Exception.MenuMauvaisTypeException;

import javax.persistence.*;

@Entity
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

    public ItemNourriture getEntree() {
        return entree;
    }

    public ItemNourriture getPlat() {
        return plat;
    }

    public ItemNourriture getDessert() {
        return dessert;
    }

    public Boisson getBoisson() {
        return boisson;
    }

    public ItemNourriture verifType(TypeNourriture typeAttendu, ItemNourriture nourriture) {
        if( typeAttendu != nourriture.getType()){
            throw new MenuMauvaisTypeException(nourriture.getNom() + " n'est pas un(e) " + typeAttendu);
        }
        return nourriture;
    }

    public Menu(ItemNourriture entree, ItemNourriture plat, ItemNourriture dessert, Boisson boisson){
            this.entree = verifType(TypeNourriture.ENTREE, entree);
            this.plat = verifType(TypeNourriture.PLAT, plat);
            this.dessert = verifType(TypeNourriture.DESSERT, dessert);
            this.boisson = boisson;
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
