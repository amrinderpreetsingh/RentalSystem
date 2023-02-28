package org.example;

public class ApartmentView extends UnitView {
    public int numberOfBedrooms;
    public int numberOfBathrooms;
    public int squareFootage;
    public String unitNumber;

    public ApartmentView(String streetName, String city, String postalCode, boolean isRented, String streetNumber, int numberOfBedrooms, int numberOfBathrooms, int squareFootage, String unitNumber) {
        super(streetName, city, postalCode, isRented, streetNumber);
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.squareFootage = squareFootage;
        this.unitNumber = unitNumber;
    }

}
