package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONValue;

import java.util.HashMap;
import java.util.Scanner;

public class Driver {
    Scanner scanner = new Scanner(System.in);
    private String option;
    RentalServiceImpl service = new RentalServiceImpl();

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
                            "9. Exit");

            try {
                option = scanner.nextLine();

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
        int propertyType = addPropertyMenu();
        System.out.println("Enter the property details :");
        System.out.print("Street Name :");
        String streetName= scanner.nextLine();
        System.out.print("City :");
        String city= scanner.nextLine();
        System.out.print("Postal Code :");
        String postalCode = scanner.nextLine();
        System.out.print("Is the unit already rented?  (Y/N) :" );
        String isRentedInput = scanner.nextLine();
        boolean isRented = isRentedInput.equalsIgnoreCase("Y");
        System.out.print("Street Number :");
        String streetNumber = scanner.nextLine();
        System.out.print("Unit Id : ");
        int unitId = Integer.parseInt(scanner.nextLine());
        System.out.println("Number of Bedrooms: ");
        int numberOfBedrooms = Integer.parseInt(scanner.nextLine());
        System.out.println("Number of Bathrooms :");
        int numberOfBathrooms = Integer.parseInt(scanner.nextLine());
        System.out.println("Square Footage :");
        int squareFootage = Integer.parseInt(scanner.nextLine());
        System.out.println("Unit Number :");
        int unitNumber = Integer.parseInt(scanner.nextLine());

        HashMap<Object, Object> obj = new HashMap<>();
        obj.put("streetName",streetName);
        obj.put("city", city);
        obj.put("postalCode", postalCode);
        obj.put("isRented",isRented);
        obj.put("streetNumber", streetNumber);
        obj.put("unitId",unitId);
        obj.put("numberOfBedrooms", numberOfBedrooms);
        obj.put("numberOfBathrooms",numberOfBathrooms);
        obj.put("squareFootage",squareFootage);
        obj.put("unitNumber", unitNumber);


        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String json = objectMapper.writeValueAsString(obj);
            System.out.println(json);
            service.addProperty(json);

//            String jsonInString = objectMapper.writeValueAsString(obj);
//            System.out.println(jsonInString);
//
//            //Convert object to JSON string and pretty print
//            jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
//            System.out.println(jsonInString);
//
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    public int addPropertyMenu(){
        System.out.print("Please select a property type :" +
                "1. Apartment " +
                "2. Condo " +
                "3. House " +
                "Enter your option : ");
        return Integer.parseInt(scanner.nextLine());
    }
}