package org.scholanova.mealdeliverapi.model;

public class MainCourse {

    String name;
    float price;
    int timeCuisson;


    public MainCourse() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getTimeCuisson() {
        return timeCuisson;
    }

    public void setTimeCuisson(int timeCuisson) {
        this.timeCuisson = timeCuisson;
    }
}
