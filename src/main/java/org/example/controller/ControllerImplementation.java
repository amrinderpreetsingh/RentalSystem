package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.RentalUnitFactory;
import org.example.model.Unit;

import java.util.ArrayList;

public class ControllerImplementation implements Controller {
    ObjectMapper objectMapper = new ObjectMapper();
    ArrayList<Unit> rentalUnits = new ArrayList<>();
    Unit unit ;
    @Override

    public void addProperty(String data) {
        System.out.println("inside add property : ");
        try {
            JsonNode jsonNode = objectMapper.readTree(data);
            unit = RentalUnitFactory.getRentalUnit("apartment",
                    jsonNode.get("streetName").asText(),
                    jsonNode.get("city").asText(),
                    jsonNode.get("postalCode").asText(),
                    jsonNode.get("isRented").asBoolean(),
                    jsonNode.get("streetNumber").asText(),
                    jsonNode.get("unitId").asInt(),
                    jsonNode.get("numberOfBedrooms").asInt(),
                    jsonNode.get("numberOfBathrooms").asInt(),
                    jsonNode.get("squareFootage").asInt(),
                    jsonNode.get("unitNumber").asText());
            System.out.println(unit);
            rentalUnits.add(unit);

            for (Unit unit : rentalUnits) {
                System.out.println(unit);
            }
        } catch (JsonMappingException ex) {
            throw new RuntimeException(ex);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
        catch (Exception e){
            e.getMessage();
        }
    }
}
