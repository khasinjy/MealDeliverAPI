package org.scholanova.mealdeliverapi.domain.Client;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String prenom;

    @Column
    private String adresse;

    @Column
    private int ptsFidelite;

    public Client() {
        this.ptsFidelite = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getPtsFidelite() {
        return ptsFidelite;
    }

    public void setPtsFidelite(int ptsFidelite) {
        this.ptsFidelite = ptsFidelite;
    }
}
