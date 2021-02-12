package org.scholanova.mealdeliverapi.domain.ItemNourriture;

import javax.persistence.*;

@Entity
@Table(name = "nourriture")
public class ItemNourriture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private float prix;

    @Column
    private String nom;

    @Column
    private int tempsPreparation;

    @Enumerated(EnumType.STRING)
    private TypeNourriture type;

    public ItemNourriture() {
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public float getPrix() {
        return prix;
    }

    public String getNom() {
        return nom;
    }

    public int getTempsPreparation() {
        return tempsPreparation;
    }

    public TypeNourriture getType() {
        return type;
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