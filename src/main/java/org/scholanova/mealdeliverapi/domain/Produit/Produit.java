package org.scholanova.mealdeliverapi.domain.Produit;

import javax.persistence.*;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Float prix;

    @Column
    private String nom;

    @Column
    private int tempsPreparation; //en minutes

    @Enumerated(EnumType.STRING)
    private TypeProduit type;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Float getPrix() {
        return prix;
    }

    public String getNom() {
        return nom;
    }

    public int getTempsPreparation() {
        return tempsPreparation;
    }

    public TypeProduit getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ELement{" +
                "id=" + id +
                ", prix=" + prix +
                ", nom='" + nom + '\'' +
                ", tempsPreparation=" + tempsPreparation +
                ", type=" + type +
                '}';
    }
}