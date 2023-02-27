package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.utilities.Constant;
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
                    jsonNode.get(Constant.StreetName).asText(),
                    jsonNode.get(Constant.City).asText(),
                    jsonNode.get(Constant.PostalCode).asText(),
                    jsonNode.get(Constant.IsRented).asBoolean(),
                    jsonNode.get(Constant.StreetNumber).asText(),
                    jsonNode.get(Constant.UnitId).asInt(),
                    jsonNode.get(Constant.NumberOfBedrooms).asInt(),
                    jsonNode.get(Constant.NumberOfBathrooms).asInt(),
                    jsonNode.get(Constant.SquareFootage).asInt(),
                    jsonNode.get(Constant.UnitNumber).asText());
            rentalUnits.add(unit);

            for (Unit unit : rentalUnits) {
                System.out.println(unit);
            }
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }
}
