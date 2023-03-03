package org.example.builders;

import org.example.model.Apartment;
import org.example.model.Unit;

public class ApartmentBuilder extends UnitBuilder{
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int squareFootage;
    private String unitNumber;

    public ApartmentBuilder(String streetName, String city, String postalCode, boolean isRented, String streetNumber, double monthlyRent,int numberOfBedrooms, int numberOfBathrooms, int squareFootage, String unitNumber) {
        super(streetName, city, postalCode, isRented, streetNumber,monthlyRent);
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.squareFootage = squareFootage;
        this.unitNumber = unitNumber;
    }

    @Override
    public Unit build() {
        return new Apartment(this);
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public int getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(int numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public int getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(int squareFootage) {
        this.squareFootage = squareFootage;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }
}
