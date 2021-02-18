package org.scholanova.mealdeliverapi.domain.Menu;

import org.scholanova.mealdeliverapi.domain.Produit.Produit;
import org.scholanova.mealdeliverapi.domain.Produit.TypeProduit;
import org.scholanova.mealdeliverapi.domain.Menu.Exception.MenuMauvaisTypeException;

import javax.persistence.*;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produit entree;

    @ManyToOne
    private Produit plat;

    @ManyToOne
    private Produit dessert;

    @ManyToOne
    private Produit boisson;

    @Column
    private Float prix=0f;

    public Long getId() {
        return id;
    }

    public Produit getEntree() {
        return entree;
    }

    public Produit getPlat() {
        return plat;
    }

    public Produit getDessert() {
        return dessert;
    }

    public Produit getBoisson() {
        return boisson;
    }

    public Float getPrix() {
        return prix;
    }

    public Produit verifType(TypeProduit typeAttendu, Produit produit) {
        if( typeAttendu != produit.getType()){
            throw new MenuMauvaisTypeException(produit.getNom() + " n'est pas un(e) " + typeAttendu);
        }
        return produit;
    }

    public Menu(Produit entree, Produit plat, Produit dessert, Produit boisson, Float prix){
            this.entree = verifType(TypeProduit.ENTREE, entree);
            this.plat = verifType(TypeProduit.PLAT, plat);
            this.dessert = verifType(TypeProduit.DESSERT, dessert);
            this.boisson = verifType(TypeProduit.BOISSON, boisson);
            this.prix = prix;
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
