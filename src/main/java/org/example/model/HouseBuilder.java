package org.example.model;

public class HouseBuilder extends UnitBuilder{
    public HouseBuilder(String streetName, String city, String postalCode, boolean isRented, String streetNumber) {
        super(streetName, city, postalCode, isRented, streetNumber);
    }

    @Override
    public Unit build() {
        return new House(this);
    }
}
