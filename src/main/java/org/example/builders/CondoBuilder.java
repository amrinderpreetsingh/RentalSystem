package org.example.builders;

import org.example.model.Condo;
import org.example.model.Unit;

public class CondoBuilder extends ApartmentBuilder{
    public CondoBuilder(String streetName, String city, String postalCode, boolean isRented, String streetNumber, double monthlyRent,int numberOfBedrooms, int numberOfBathrooms, int squareFootage, String unitNumber) {
        super(streetName, city, postalCode, isRented, streetNumber, monthlyRent,numberOfBedrooms, numberOfBathrooms, squareFootage, unitNumber);
    }
    @Override
    public Unit build() {
        return new Condo(this);
    }
}
