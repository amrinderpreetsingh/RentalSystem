package org.example;

public class Main {
    public static void main(String[] args) {
        Unit apartment = RentalUnitFactory.getRentalUnit("apartment", "sherbrooke","Montreal",
                "h4b 1P5", false,"22", 6841,2,2,
                1500, "2");
        Unit condo = RentalUnitFactory.getRentalUnit("condo", "sherbrooke","Montreal",
                "h4b 1P5", false,"22", 6841,2,2,
                1500, "2");
        //streetName, city, postalCode, isRented, streetNumber, unitId
        Unit house = RentalUnitFactory.getRentalUnit("house", "sherbrooke","Montreal",
                "h4b 1P5", false,"22", 6841,2,2,
                1500, "2");

        System.out.println(apartment);
        System.out.println(condo);
        System.out.println(house);
    }
}