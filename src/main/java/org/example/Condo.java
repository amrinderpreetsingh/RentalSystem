package org.example;

public class Condo extends Apartment{

    public Condo(String streetName, String city, String postalCode, boolean isRented, String streetNumber, int unitId, int numberOfBedrooms, int numberOfBathrooms, int squareFootage, String unitNumber) {
        super(streetName, city, postalCode, isRented, streetNumber, unitId, numberOfBedrooms, numberOfBathrooms, squareFootage, unitNumber);
    }

    @Override
    public String toString() {
        return "condo was called"+
                 "numberOfBedrooms=" + super.getNumberOfBedrooms()+
                    ", numberOfBathrooms=" + super.getNumberOfBathrooms()+
                    ", squareFootage=" + super.getSquareFootage() +
                    ", unitNumber='" + super.getUnitNumber() + '\'' +
                    '}';
    }
}
