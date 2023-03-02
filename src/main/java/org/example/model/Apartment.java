package org.example.model;

public class Apartment extends Unit{
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private int squareFootage;
    private String unitNumber;

    public Apartment(ApartmentBuilder apartmentBuilder){
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

}
