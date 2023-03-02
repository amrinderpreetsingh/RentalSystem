package org.example.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.utilities.Constant;
import org.example.controller.ControllerImplementation;

import java.util.HashMap;
import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);
    ObjectMapper objectMapper = new ObjectMapper();
    ControllerImplementation controllerImplementation = new ControllerImplementation();

    public void menu() {
        System.out.println("Please select an option  :");
        while (true) {
            System.out.print(
                    "1. Add a property\n" +
                            "2. Add a tenant\n" +
                            "3. Rent a unit\n" +
                            "4. Display properties\n" +
                            "5. Display tenants\n" +
                            "6. Display rented units\n" +
                            "7. Display vacant units\n" +
                            "8. Display all leases\n" +
                            "9. Exit\n" +
                            "Enter your choice :");

            try {
                String option = scanner.nextLine();

                switch (Integer.parseInt(option)) {
                    case 1 -> {
                        addProperty();
                    }
//                    case 2 -> {
//                    }
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

    public void addProperty(){
        HashMap<Object, Object> obj = new HashMap<>();
        obj.put(Constant.UnitType, addPropertyMenu());
        System.out.println("Enter the property details :");
        System.out.print("Street Name :");
        obj.put(Constant.StreetName,scanner.nextLine());
        System.out.print("City :");
        obj.put(Constant.City, scanner.nextLine());
        System.out.print("Postal Code :");
        obj.put(Constant.PostalCode, scanner.nextLine());
        System.out.print("Is the unit already rented?  (Y/N) :" );
        String isRentedInput = scanner.nextLine();
        boolean isRented = isRentedInput.equalsIgnoreCase("Y");
        obj.put(Constant.IsRented, isRented);
        System.out.print("Street Number :");
        obj.put(Constant.StreetNumber, scanner.nextLine());
        System.out.print("Unit Id : ");
        obj.put(Constant.UnitId, scanner.nextLine());
        System.out.print("Number of Bedrooms: ");
        obj.put(Constant.NumberOfBedrooms, scanner.nextLine());
        System.out.print("Number of Bathrooms :");
        obj.put(Constant.NumberOfBathrooms, scanner.nextLine());
        System.out.print("Square Footage :");
        obj.put(Constant.SquareFootage, scanner.nextLine());
        System.out.print("Unit Number :");
        obj.put(Constant.UnitNumber, scanner.nextLine());

        try {
            String json = objectMapper.writeValueAsString(obj);
            controllerImplementation.addProperty(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    public String addPropertyMenu(){
        System.out.print("Please select a property type :\n" +
                "1. Apartment \n" +
                "2. Condo \n" +
                "3. House \n" +
                "Enter your option : ");

        int selection = Integer.parseInt(scanner.nextLine());
        switch (selection) {
            case 1 -> {return Constant.Apartment;}
            case 2 -> {return Constant.Condo;}
            case 3 ->{return Constant.House;}
        }
        return null;
    }
}