package org.example.model;

import org.example.builders.ApartmentBuilder;

public class Apartment extends Unit {
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int squareFootage;
    private String unitNumber;

    public Apartment(ApartmentBuilder apartmentBuilder) {
        super(apartmentBuilder);
        this.numberOfBedrooms = apartmentBuilder.getNumberOfBedrooms();
        this.numberOfBathrooms = apartmentBuilder.getNumberOfBathrooms();
        this.squareFootage = apartmentBuilder.getSquareFootage();
        this.unitNumber = apartmentBuilder.getUnitNumber();
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
        String info = "Unit Number: " + this.getUnitNumber() + "\n" +
                "Street Number: " + this.getStreetNumber() + "\n" +
                "Street Name: " + this.getStreetName() + "\n" +
                "City: " + this.getCity() + "\n" +
                "Postal Code: " + this.getPostalCode() + "\n" +
                "Number of Bedrooms: " + this.getNumberOfBedrooms() + "\n" +
                "Number of Bathrooms: " + this.getNumberOfBathrooms() + "\n" +
                "Square Footage: " + this.getSquareFootage() + "\n" +
                "Monthly Rent: " + this.getMonthlyRent();
        return info;
    }
}
