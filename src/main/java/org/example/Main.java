package org.example;

import org.example.model.Apartment;
import org.example.view.View;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Rental Management System : ");
        View view = new View();
        view.menu();

//        Unit apartment = RentalUnitFactory.getRentalUnit("apartment", "sherbrooke","Montreal",
//                "h4b 1P5", false,"22", 6841,2,2,
//                1500, "2");
//        Unit condo = RentalUnitFactory.getRentalUnit("condo", "sherbrooke","Montreal",
//                "h4b 1P5", false,"22", 6841,2,2,
//                1500, "2");
//        //streetName, city, postalCode, isRented, streetNumber, unitId
//        Unit house = RentalUnitFactory.getRentalUnit("house", "sherbrooke","Montreal",
//                "h4b 1P5", false,"22", 6841,2,2,
//                1500, "2");
//
//        System.out.println(apartment);
//        System.out.println(condo);
//        System.out.println(house);
    }
}