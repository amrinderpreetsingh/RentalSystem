package org.example.controller;

import org.example.model.TenantBuilder;
import org.example.model.UnitBuilder;
import org.example.model.Unit;
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
