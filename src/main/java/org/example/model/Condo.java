package org.example.model;

import org.example.builders.ApartmentBuilder;

public class Condo extends Apartment {

    public Condo(ApartmentBuilder apartmentBuilder) {
        super(apartmentBuilder);
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
