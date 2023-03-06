package org.example.controller;

import org.example.builders.LeaseBuilder;
import org.example.builders.TenantBuilder;
import org.example.builders.UnitBuilder;
import org.example.model.Lease;
import org.example.model.Tenant;
import org.example.model.Unit;

import java.util.ArrayList;

public interface Controller {
    /**
     * Method to add property to the system.
     * @param unitBuilder
     */
    public void addProperty(UnitBuilder unitBuilder);

    /**
     * Method to add tenant to the system.
     * @param tenantBuilder
     */
    public void addTenant(TenantBuilder tenantBuilder);

    /**
     * Get all properties of one Type(Apartment,Condo,House).
     * @param type
     * @return
     */
    public ArrayList<Unit> getPropertiesByType(String type);

    /**
     * Get property by unitId attribute.
     * @param id
     * @return
     */
    public Unit getPropertyById(int id);

    /**
     * Get details of tenant using email address.
     * @param email
     * @return
     */
    public Tenant getTenantByEmail(String email);

    /**
     * Add lease in the system.
     * @param leaseBuilder
     */
    public void addLease(LeaseBuilder leaseBuilder);

    /**
     * Get all the leases present in the system.
     * @return
     */
    public ArrayList<Lease> getLeases();

    /**
     * Get all the properties present in the system.
     * @return
     */
    public ArrayList<Unit> getProperties();

    /**
     * Get all the tenants.
     * @return
     */
    public ArrayList<Tenant> getTenants();

    /**
     * Get all the rented properties.
     * @return
     */
    public ArrayList<Unit> getRentedUnits();

    /**
     * Get all the vacant properties.
     * @return
     */
    public ArrayList<Unit> getVacantUnits();

    /**
     * Subscribe tenant to the given property.
     * @param unit
     * @param tenant
     */
    public void subscribeTenantToUnit(Unit unit, Tenant tenant);
}
