package org.scholanova.mealdeliverapi.Nourriture.Boisson.model;

public class Boisson {

    float price;
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
