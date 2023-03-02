package org.example.model;

public class CondoBuilder extends ApartmentBuilder{
    public CondoBuilder(String streetName, String city, String postalCode, boolean isRented, String streetNumber, int numberOfBedrooms, int numberOfBathrooms, int squareFootage, String unitNumber) {
        super(streetName, city, postalCode, isRented, streetNumber, numberOfBedrooms, numberOfBathrooms, squareFootage, unitNumber);
    }
    @Override
    public Unit build() {
        return new Condo(this);
    }
}
