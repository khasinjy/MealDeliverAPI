package org.scholanova.mealdeliverapi.domain;

import javax.persistence.*;

@Entity
public class Boisson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    float price;
    @Column
    String nom;

    public Boisson() {
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Boisson{" +
                "price=" + price +
                ", nom='" + nom + '\'' +
                '}';
    }
}
