package org.example.utilities;

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
        db=mock(Database.class);
        service=new Service(db);
    }

    @Test
    void getProperties() {
        Unit house1 = new HouseBuilder("Sherbrooke", "Montreal", "H4B1P5", false, "7", 2000).build();
        ArrayList<Unit> units=new ArrayList<Unit>();
        units.add(house1);
        when(db.getProperties()).thenReturn(units);
        ArrayList<Unit>a=service.getProperties();
        assertEquals(1,a.size());
    }
}