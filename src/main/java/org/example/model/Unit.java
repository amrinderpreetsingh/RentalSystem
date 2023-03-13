package org.example.model;

import org.example.builders.UnitBuilder;

public abstract class Unit {
    private String streetName;
    private String city;
    private String postalCode;
    private boolean isRented;
    private String streetNumber;
    private double monthlyRent;
    private int unitId;
    private static int _unitId = 101;


    public Unit(UnitBuilder unitBuilder) {
        this.streetName = unitBuilder.getStreetName();
        this.city = unitBuilder.getCity();
        this.postalCode = unitBuilder.getPostalCode();
        this.isRented = unitBuilder.getIsRented();
        this.streetNumber = unitBuilder.getStreetNumber();
        this.monthlyRent = unitBuilder.getMonthlyRent();
        this.unitId = _unitId;
        _unitId++;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public int getUnitId() {
        return unitId;
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

    public boolean getIsRented() {
        return isRented;
    }

    public void setIsRented(boolean rented) {
        isRented = rented;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Override
    public abstract String toString();
}
