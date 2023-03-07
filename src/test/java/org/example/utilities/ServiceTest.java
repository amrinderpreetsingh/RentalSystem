package org.example.utilities;

import org.example.builders.ApartmentBuilder;
import org.example.builders.CondoBuilder;
import org.example.builders.TenantBuilder;
import org.example.model.Tenant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.builders.HouseBuilder;
import org.example.model.Unit;
import org.example.utilities.Database;
import org.example.utilities.Service;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    Database db;
    Service service;

    @BeforeEach
    void setUp() {
        db = mock(Database.class);
        service = new Service(db);
    }

    @Test
    void getProperties() {
        Unit house1 = new HouseBuilder("Sherbrooke", "Montreal", "H4B1P5", false, "7", 2000).build();
        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(house1);
        when(db.getProperties()).thenReturn(units);
        ArrayList<Unit> a = service.getProperties();
        assertEquals(units.size(), a.size());
    }

    @Test
    void getPropertyByIdReturnsUnit() {
        Unit house1 = new HouseBuilder("Sherbrooke", "Montreal", "H4B1P5", false, "7", 2000).build();
        int id = house1.getUnitId();
        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(house1);
        when(db.getProperties()).thenReturn(units);
        Unit unit = service.getPropertyById(id);
        assertEquals(house1, unit);
    }

    @Test
    void getPropertyByIdReturnsNull() {
        Unit house = new HouseBuilder("Sherbrooke", "Montreal", "H4B1P5", false, "7", 2000).build();
        int id = 1;
        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(house);
        when(db.getProperties()).thenReturn(units);
        Unit unit = service.getPropertyById(id);
        assertEquals(null, unit);
    }

    @Test
    void getPropertiesByTypeForHouse() {
        Unit house = new HouseBuilder("Sherbrooke", "Montreal", "H4B1P5", false, "7", 2000).build();
        Unit apartment = new ApartmentBuilder("Rue Maher", "Asr", "143001", true, "7", 1400, 3, 1, 150, "2").build();
        Unit house2 = new HouseBuilder("Rosedale", "Montreal", "H4B1P5", false, "7", 2000).build();

        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(house);
        units.add(apartment);
        units.add(house2);
        when(db.getProperties()).thenReturn(units);
        ArrayList<Unit> result = service.getPropertiesByType(Constant.HOUSE);
        assertEquals(2, result.size());
        assertEquals(house.getStreetName(), result.get(0).getStreetName());
    }

    @Test
    void getPropertiesByTypeForApartment() {
        Unit house = new HouseBuilder("Sherbrooke", "Montreal", "H4B1P5", false, "7", 2000).build();
        Unit apartment = new ApartmentBuilder("Rue Maher", "Asr", "143001", true, "7", 1400, 3, 1, 150, "2").build();
        Unit house2 = new HouseBuilder("Rosedale", "Montreal", "H4B1P5", false, "7", 2000).build();

        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(house);
        units.add(apartment);
        units.add(house2);
        when(db.getProperties()).thenReturn(units);
        ArrayList<Unit> result = service.getPropertiesByType(Constant.APARTMENT);
        assertEquals(1, result.size());
        assertEquals(apartment.getStreetName(), result.get(0).getStreetName());
    }

    @Test
    void getPropertiesByTypeForCondo() {
        Unit house = new HouseBuilder("Sherbrooke", "Montreal", "H4B1P5", false, "7", 2000).build();
        Unit apartment = new ApartmentBuilder("Rue Maher", "Asr", "143001", true, "7", 1400, 3, 1, 150, "2").build();
        Unit house2 = new HouseBuilder("Rosedale", "Montreal", "H4B1P5", false, "7", 2000).build();
        Unit condo = new CondoBuilder("Punjab", "Asr", "143001", true, "7", 1400, 3, 1, 150, "2").build();
        Unit condo1 = new CondoBuilder("Rue Maher", "Asr", "143001", true, "7", 1400, 3, 1, 150, "2").build();

        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(house);
        units.add(apartment);
        units.add(house2);
        units.add(condo);
        units.add(condo1);
        when(db.getProperties()).thenReturn(units);
        ArrayList<Unit> result = service.getPropertiesByType(Constant.CONDO);
        assertEquals(2, result.size());
        assertEquals(condo.getStreetName(), result.get(0).getStreetName());
    }

    @Test
    void getTenants() {
        Tenant tenant = new TenantBuilder("Gagan", "8968147777", "gagan@gmail.com").build();
        Tenant tenant1 = new TenantBuilder("Sunn", "8968147777", "gagan@gmail.com").build();
        ArrayList<Tenant> tenants = new ArrayList<>();
        tenants.add(tenant);
        when(db.getTenants()).thenReturn(tenants);
        ArrayList<Tenant> a = service.getTenants();
        assertEquals(tenants.size(), a.size());
    }

    @Test
    void getVacantUnits() {
        Unit house = new HouseBuilder("Sherbrooke", "Montreal", "H4B1P5", true, "7", 2000).build();
        Unit apartment = new ApartmentBuilder("Rue Maher", "Asr", "143001", true, "7", 1400, 3, 1, 150, "2").build();
        Unit house2 = new HouseBuilder("Rosedale", "Montreal", "H4B1P5", false, "7", 2000).build();

        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(house);
        units.add(apartment);
        units.add(house2);
        when(db.getProperties()).thenReturn(units);
        ArrayList<Unit> result = service.getVacantUnits();

        assertEquals(1, result.size());
        assertEquals(house2.getIsRented(), result.get(0).getIsRented());
        assertEquals(house2.getStreetName(), result.get(0).getStreetName());
    }

    @Test
    void getVacantUnitsReturnZeroUnitsIfAllAreRented() {
        Unit house = new HouseBuilder("Sherbrooke", "Montreal", "H4B1P5", true, "7", 2000).build();
        Unit apartment = new ApartmentBuilder("Rue Maher", "Asr", "143001", true, "7", 1400, 3, 1, 150, "2").build();
        Unit house2 = new HouseBuilder("Rosedale", "Montreal", "H4B1P5", true, "7", 2000).build();

        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(house);
        units.add(apartment);
        units.add(house2);
        when(db.getProperties()).thenReturn(units);
        ArrayList<Unit> result = service.getVacantUnits();

        assertEquals(0, result.size());
    }

    @Test
    void getRentedUnits() {
        Unit house = new HouseBuilder("Sherbrooke", "Montreal", "H4B1P5", true, "7", 2000).build();
        Unit apartment = new ApartmentBuilder("Rue Maher", "Asr", "143001", true, "7", 1400, 3, 1, 150, "2").build();
        Unit house2 = new HouseBuilder("Rosedale", "Montreal", "H4B1P5", false, "7", 2000).build();

        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(house);
        units.add(apartment);
        units.add(house2);
        when(db.getProperties()).thenReturn(units);
        ArrayList<Unit> result = service.getVacantUnits();

        assertEquals(1, result.size());
    }

    @Test
    void getRentedUnitsReturnZeroUnitsIfAllAreVacant() {
        Unit house = new HouseBuilder("Sherbrooke", "Montreal", "H4B1P5", false, "7", 2000).build();
        Unit apartment = new ApartmentBuilder("Rue Maher", "Asr", "143001", false, "7", 1400, 3, 1, 150, "2").build();
        Unit house2 = new HouseBuilder("Rosedale", "Montreal", "H4B1P5", false, "7", 2000).build();

        ArrayList<Unit> units = new ArrayList<Unit>();
        units.add(house);
        units.add(apartment);
        units.add(house2);
        when(db.getProperties()).thenReturn(units);
        ArrayList<Unit> result = service.getVacantUnits();

        assertEquals(3, result.size());
    }
}