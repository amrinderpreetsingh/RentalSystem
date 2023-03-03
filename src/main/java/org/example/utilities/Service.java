package org.example.utilities;

import org.example.builders.TenantBuilder;
import org.example.builders.UnitBuilder;
import org.example.model.*;

import java.util.ArrayList;

public class Service {
    ArrayList<Unit> properties = new ArrayList<>();
    ArrayList<Tenant> tenants = new ArrayList<>();

    public void addProperty(UnitBuilder builder) {
        Unit unit = builder.build();
        properties.add(unit);
        for (Unit property : properties) {
            System.out.println(property.toString());
        }
    }

    public void addTenant(TenantBuilder builder) {
        Tenant tenant = builder.build();
        tenants.add(tenant);
        for (Tenant t : tenants) {
            System.out.println(t.getClass());
        }
    }
}
