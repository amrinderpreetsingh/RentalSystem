package org.example.controller;

import org.example.builders.TenantBuilder;
import org.example.builders.UnitBuilder;
import org.example.utilities.Service;

public class RentalController implements Controller {

    Service service = new Service();

    @Override
    public void addProperty(UnitBuilder unitBuilder) {
        service.addProperty(unitBuilder);
    }

    public void addTenant(TenantBuilder tenantBuilder) {
        service.addTenant(tenantBuilder);
    }
}
