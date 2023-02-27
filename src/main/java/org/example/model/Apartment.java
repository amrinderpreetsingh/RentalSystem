package org.example.model;

public class Apartment extends Unit{
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int squareFootage;
    private String unitNumber;

    public Apartment(String streetName, String city, String postalCode, boolean isRented, String streetNumber, int unitId, int numberOfBedrooms, int numberOfBathrooms, int squareFootage, String unitNumber) {
        super(streetName, city, postalCode, isRented, streetNumber, unitId);
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.squareFootage = squareFootage;
        this.unitNumber = unitNumber;
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

    @Override
    public String toString() {
        return "apartment was called"+
                "" +
                "Apartment{" +
                "numberOfBedrooms=" + numberOfBedrooms +
                ", numberOfBathrooms=" + numberOfBathrooms +
                ", squareFootage=" + squareFootage +
                ", unitNumber='" + unitNumber + '\'' +
                '}';
    }
}
