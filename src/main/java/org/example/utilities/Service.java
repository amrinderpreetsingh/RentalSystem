package org.example.utilities;

import org.example.builders.TenantBuilder;
import org.example.builders.UnitBuilder;
import org.example.model.*;

import java.util.ArrayList;

public class Service {
     ArrayList<Unit> properties = new ArrayList<>();
     ArrayList<Tenant> tenants = new ArrayList<>();
      public ArrayList<Unit> getProperties() {
        return properties;
     }

    public ArrayList<Tenant> getTenants() {
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
