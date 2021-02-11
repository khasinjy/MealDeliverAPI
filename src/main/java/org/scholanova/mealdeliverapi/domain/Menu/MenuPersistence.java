package org.scholanova.mealdeliverapi.domain.Menu;

public class MenuPersistence {

    private String entree;
    private String plat;
    private String dessert;
    private String boisson;

    public String getEntree() {
        return entree;
    }

    public void setEntree(String entree) {
        this.entree = entree;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public String getBoisson() {
        return boisson;
    }

    public void setBoisson(String boisson) {
        this.boisson = boisson;
    }

    @Override
    public String toString() {
        return "MenuPersistence{" +
                "entree='" + entree + '\'' +
                ", plat='" + plat + '\'' +
                ", dessert='" + dessert + '\'' +
                ", boisson='" + boisson + '\'' +
                '}';
    }
}
