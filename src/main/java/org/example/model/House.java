package org.example.model;

import org.example.builders.UnitBuilder;

public class House extends Unit {

    public House(UnitBuilder unitBuilder) {
        super(unitBuilder);
    }

    @Override
    public String toString() {
        String info = "Street Number: " + this.getStreetNumber() + "\n" +
                "Street Name: " + this.getStreetName() + "\n" +
                "City: " + this.getCity() + "\n" +
                "Postal Code: " + this.getPostalCode() + "\n" +
                "Monthly Rent: " + this.getMonthlyRent() + "\n" +
                "IsRented: " + this.getIsRented() + "\n" +
                "Unit ID: " + this.getUnitId();
        return info;
    }
}
