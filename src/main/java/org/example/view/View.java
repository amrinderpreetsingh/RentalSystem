package org.example.view;

import org.example.builders.*;
import org.example.utilities.Constant;
import org.example.controller.RentalController;

import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);
    RentalController rentalController = new RentalController();

    public void menu() {
        while (true) {
            System.out.println("Please select an option: ");
            System.out.print(
                    "1. Add a property\n" +
                            "2. Add a tenant\n" +
                            "3. Rent a unit\n" +
                            "4. Display properties\n" +
                            "5. Display tenants\n" +
                            "6. Display rented units\n" +
                            "7. Display vacant units\n" +
                            "8. Display all leases\n" +
                            "9. Exit \n" +
                            "Enter your option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1 -> addProperty();
                    case 2 -> addTenant();
//                    case 3 -> {
//                    }
//                    case 4 -> {
//                    }
//                    case 5 -> {
//                    }
//                    case 6 -> {
//                    }
//                    case 7 -> {
//                    }
//                    case 8 -> {
//                    }
                    case 9 -> System.exit(-1);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Wrong input was provided. Please Try again.");
            }
        }
    }

    public void addProperty() {
        String propertyType = addPropertyMenu();
        UnitBuilder builder = null;
        System.out.println("Enter the property details");
        System.out.print("Street Name: ");
        String streetName = scanner.nextLine();
        System.out.print("Street Number: ");
        String streetNumber = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("Postal Code: ");
        String postalCode = scanner.nextLine();
        System.out.print("Monthly Rent: ");
        double monthlyRent = Double.parseDouble(scanner.nextLine().trim());
        boolean isRented = false;
        if (propertyType.equalsIgnoreCase(Constant.APARTMENT) || propertyType.equalsIgnoreCase(Constant.CONDO)) {
            System.out.print("Number of Bedrooms: ");
            int numberOfBedrooms = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Number of Bathrooms: ");
            int numberOfBathrooms = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Square Footage: ");
            int squareFootage = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Unit Number: ");
            String unitNumber = scanner.nextLine().trim();
            if (propertyType.equalsIgnoreCase(Constant.APARTMENT)) {
                builder = new ApartmentBuilder(streetName, city, postalCode, isRented, streetNumber, monthlyRent, numberOfBedrooms, numberOfBathrooms, squareFootage, unitNumber);
            } else {
                builder = new CondoBuilder(streetName, city, postalCode, isRented, streetNumber, monthlyRent, numberOfBedrooms, numberOfBathrooms, squareFootage, unitNumber);
            }
        } else {
            builder = new HouseBuilder(streetName, city, postalCode, isRented, streetNumber, monthlyRent);
        }

        rentalController.addProperty(builder);
    }

    public String addPropertyMenu() {
        System.out.print("Please select a property type >>\n" +
                "1. Apartment \n" +
                "2. Condo \n" +
                "3. House \n" +
                "Enter your option: ");

        int selection = Integer.parseInt(scanner.nextLine());
        switch (selection) {
            case 1 -> {
                return Constant.APARTMENT;
            }
            case 2 -> {
                return Constant.CONDO;
            }
            case 3 -> {
                return Constant.HOUSE;
            }
        }
        return null;
    }

    public void addTenant(){
        TenantBuilder tenantBuilder = null;
        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("email: ");
        String email = scanner.nextLine();
        tenantBuilder = new TenantBuilder(fullName, phoneNumber, email);

        rentalController.addTenant(tenantBuilder);
    }

}