package org.example.controller;

import org.example.builders.LeaseBuilder;
import org.example.builders.TenantBuilder;
import org.example.builders.UnitBuilder;
import org.example.model.Lease;
import org.example.model.Tenant;
import org.example.model.Unit;
import org.example.utilities.Service;

import java.util.ArrayList;

public class RentalController implements Controller {

    Service service = new Service();

    /**
     * {@inheritDoc}
     *
     * @param unitBuilder
     */
    @Override
    public void addProperty(UnitBuilder unitBuilder) {
        service.addProperty(unitBuilder);
    }

    /**
     * {@inheritDoc}
     *
     * @param tenantBuilder
     */
    public void addTenant(TenantBuilder tenantBuilder) {
        service.addTenant(tenantBuilder);
    }

    /**
     * {@inheritDoc}
     *
     * @param type
     * @return
     */
    public ArrayList<Unit> getPropertiesByType(String type) {
        return service.getPropertiesByType(type);
    }

    /**
     * {@inheritDoc}
     *
     * @param id
     * @return
     */
    public Unit getPropertyById(int id) {
        return service.getPropertyById(id);
    }

    /**
     * {@inheritDoc}
     *
     * @param email
     * @return
     */
    public Tenant getTenantByEmail(String email) {
        return service.getTenantByEmail(email);
    }

    /**
     * {@inheritDoc}
     *
     * @param leaseBuilder
     */
    public void addLease(LeaseBuilder leaseBuilder) {
        service.addLease(leaseBuilder);
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    public ArrayList<Lease> getLeases() {
        return service.getAllLeases();
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    public ArrayList<Unit> getProperties() {
        return service.getProperties();
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    public ArrayList<Tenant> getTenants() {
        return service.getTenants();
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    public ArrayList<Unit> getRentedUnits() {
        return service.getRentedUnits();
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    public ArrayList<Unit> getVacantUnits() {
        return service.getVacantUnits();
    }
}
