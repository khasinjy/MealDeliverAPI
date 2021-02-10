package org.scholanova.mealdeliverapi.domain;

import javax.persistence.*;

@Entity
@Table(name = "boissons")
public class Boisson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    float prix;

    @Column
    String nom;

    public Boisson() {
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
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
                "prix=" + prix +
                ", nom='" + nom + '\'' +
                '}';
    }
}
