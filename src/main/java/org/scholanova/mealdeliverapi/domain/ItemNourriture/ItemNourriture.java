package org.scholanova.mealdeliverapi.domain.ItemNourriture;

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
    @Enumerated(EnumType.STRING)
    TypeNourriture type;

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

    public TypeNourriture getType() {
        return type;
    }

    public void setType(TypeNourriture type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ItemNourriture{" +
                "id=" + id +
                ", prix=" + prix +
                ", nom='" + nom + '\'' +
                ", tempsPreparation=" + tempsPreparation +
                ", type=" + type +
                '}';
    }
}