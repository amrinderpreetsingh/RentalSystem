package org.example.builders;

import org.example.model.Unit;

public abstract class UnitBuilder {
    private String streetName;
    private String city;
    private String postalCode;
    private boolean isRented;
    private String streetNumber;

    private double monthlyRent;

    public UnitBuilder(String streetName, String city, String postalCode, boolean isRented, String streetNumber,double monthlyRent) {
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.isRented = isRented;
        this.streetNumber = streetNumber;
        this.monthlyRent=monthlyRent;
    }
    public abstract Unit build();

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
