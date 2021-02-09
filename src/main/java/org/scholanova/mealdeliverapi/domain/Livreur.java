package org.scholanova.mealdeliverapi.domain;

public class Livreur {
    int id;
    String prenom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public Livreur(String prenom) {
        this.prenom = prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
