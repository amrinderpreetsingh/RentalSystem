package org.example;

public class House extends Unit{
    public House(String streetName, String city, String postalCode, boolean isRented, String streetNumber, int unitId) {
        super(streetName, city, postalCode, isRented, streetNumber, unitId);
    }

    @Override
    public String toString() {
        return "House was called with "+  super.getStreetName() + " " + super.getCity() + super.getUnitId();
    }
}
