package org.example.model;

public class House extends Unit {

    public House(UnitBuilder unitBuilder) {
        super(unitBuilder);
    }

    @Override
    public String toString() {
        String info = "Street Number: " + this.getStreetNumber() + "\n" +
                "Street Name: " + this.getStreetName() + "\n" +
                "City: " + this.getCity() + "\n" +
                "Postal Code: " + this.getPostalCode() + "\n";
        return info;
    }
}
