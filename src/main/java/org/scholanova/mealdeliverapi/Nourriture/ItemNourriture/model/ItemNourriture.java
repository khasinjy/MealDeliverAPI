package org.scholanova.mealdeliverapi.Nourriture.ItemNourriture.model;

import org.scholanova.mealdeliverapi.Enum.EtatCommande;

public class ItemNourriture {

    float prix;
    String nom;
    int tempsDeCuisson;
    EtatCommande etatPreparation;

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

    public int getTempsDeCuisson() {
        return tempsDeCuisson;
    }

    public void setTempsDeCuisson(int tempsDeCuisson) {
        this.tempsDeCuisson = tempsDeCuisson;
    }

    public EtatCommande getEtatPreparation() {
        return etatPreparation;
    }

    public void setEtatPreparation(EtatCommande etatPreparation) {
        this.etatPreparation = etatPreparation;
    }

    @Override
    public String   toString() {
        return "ItemNourriture{" +
                "prix=" + prix +
                ", nom='" + nom + '\'' +
                ", tempsDeCuisson=" + tempsDeCuisson +
                ", etatPreparation=" + etatPreparation +
                '}';
    }
}
