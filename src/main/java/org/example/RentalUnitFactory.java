package org.example;

public class RentalUnitFactory {
    public static Unit getRentalUnit(String unitType, String streetName, String city, String postalCode,
                                     boolean isRented, String streetNumber, int unitId, int numberOfBedrooms,
                                     int numberOfBathrooms, int squareFootage, String unitNumber){

        if(unitType.equalsIgnoreCase("apartment")){
            return new Apartment(streetName,city,postalCode,isRented, streetNumber, unitId,
                    numberOfBedrooms, numberOfBathrooms, squareFootage ,unitNumber);
        }else if(unitType.equalsIgnoreCase("condo")){
            return new Condo(streetName, city, postalCode, isRented, streetNumber, unitId,
                    numberOfBedrooms, numberOfBathrooms, squareFootage, unitNumber);
        }else if(unitType.equalsIgnoreCase("house")){
            return new House(streetName, city, postalCode, isRented, streetNumber, unitId);
        }else {
            throw new IllegalArgumentException("No such rental Unit available.");
        }
    }
}
