package org.scholanova.mealdeliverapi.domain.ItemNourriture;

import org.scholanova.mealdeliverapi.domain.Restaurant;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nourriture", uniqueConstraints = @UniqueConstraint(columnNames={"nom"}))
public class ItemNourriture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private float prix;

    @Column
    private String nom;

    @Column(name = "TEMPSPREPARATION")
    private int tempsPreparation;

    @Enumerated(EnumType.STRING)
    private TypeNourriture type;

    @ManyToMany(mappedBy = "items")
    List<Restaurant> restaurants;

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

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    @Override
    public String toString() {
        return "ItemNourriture{" +
                "id=" + id +
                ", prix=" + prix +
                ", nom='" + nom + '\'' +
                ", tempsPreparation=" + tempsPreparation +
                ", type=" + type +
                ", restaurants=" + restaurants +
                '}';
    }
}