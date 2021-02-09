package org.scholanova.mealdeliverapi.domain;

import org.scholanova.mealdeliverapi.domain.Commande.EtatCommande;

import javax.persistence.*;

@Entity
public class ItemNourriture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    float prix;
    @Column
    String nom;
    @Column
    int tempsPreparation;

    public ItemNourriture() {
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

    public int getTempsPreparation() {
        return tempsPreparation;
    }

    public void setTempsPreparation(int tempsPreparation) {
        this.tempsPreparation = tempsPreparation;
    }

    @Override
    public String   toString() {
        return "ItemNourriture{" +
                "prix=" + prix +
                ", nom='" + nom + '\'' +
                ", tempsDeCuisson=" + tempsPreparation +
                '}';
    }
}
