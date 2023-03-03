package org.example.utilities;

import org.example.builders.TenantBuilder;
import org.example.builders.UnitBuilder;
import org.example.model.*;

import java.util.ArrayList;

public class Service {
    static ArrayList<Unit> properties = new ArrayList<>();
    static ArrayList<Tenant> tenants = new ArrayList<>();
    public static ArrayList<Unit> getProperties() {
        return properties;
    }

    public static ArrayList<Tenant> getTenants() {
        return tenants;
    }



    public void addProperty(UnitBuilder builder) {
        Unit unit = builder.build();
        properties.add(unit);
    }

    public void addTenant(TenantBuilder builder) {
        Tenant tenant = builder.build();
        tenants.add(tenant);
    }
}
