package com.cqut.cat.se.fooddelivery.entity;

public class Business {
    private String name;
    private int timeConsumption;
    private int monthlySales;
    private float rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeConsumption() {
        return timeConsumption;
    }

    public void setTimeConsumption(int timeConsumption) {
        this.timeConsumption = timeConsumption;
    }

    public int getMonthlySales() {
        return monthlySales;
    }

    public void setMonthlySales(int monthlySales) {
        this.monthlySales = monthlySales;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
