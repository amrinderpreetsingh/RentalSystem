package org.example.utilities;

import org.example.builders.LeaseBuilder;
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

    ArrayList<Lease> leases = new ArrayList<>();

    public void addProperty(UnitBuilder builder) {
        Unit unit = builder.build();
        properties.add(unit);
    }

    public void addTenant(TenantBuilder builder) {
        Tenant tenant = builder.build();
        tenants.add(tenant);
    }

    public ArrayList<Unit> getAllProperties() {
        return properties;
    }

    public ArrayList<Unit> getPropertiesByType(String type) {
        ArrayList<Unit> propertiesOfOneType = new ArrayList<>();
        for (Unit property : properties) {
            if (property.getClass().getSimpleName().equalsIgnoreCase(type)) {
                propertiesOfOneType.add(property);
            }
        }
        return propertiesOfOneType;
    }

    public Unit getPropertyById(int id) {
        for (Unit property : properties) {
            if (property.getUnitId() == id) {
                return property;
            }
        }
        return null;
    }

    public Tenant getTenantByEmail(String email) {
        for (Tenant tenant : tenants) {
            if (tenant.getEmail().equalsIgnoreCase(email)) {
                return tenant;
            }
        }
        return null;
    }

    public void addLease(LeaseBuilder builder) {
        builder.getTenant().setMonthlyRent(builder.getUnit().getMonthlyRent());
        builder.getTenant().setRentedUnitId(builder.getUnit().getUnitId());
        builder.getUnit().setIsRented(true);
        Lease unit = builder.build();
        leases.add(unit);
        for (Lease lease : leases) {
            System.out.println(lease);
        }
    }

    public ArrayList<Lease> getAllLeases() {
        return leases;
    }

    public ArrayList<Unit> getRentedUnits() {
        ArrayList<Unit> rentedUnits = new ArrayList<>();
        for (Unit unit : properties) {
            if (unit.getIsRented()) {
                rentedUnits.add(unit);
            }
        }
        return rentedUnits;
    }

    public ArrayList<Unit> getVacantUnits() {
        ArrayList<Unit> vacantUnits = new ArrayList<>();
        for (Unit unit : properties) {
            if (!unit.getIsRented()) {
                vacantUnits.add(unit);
            }
        }
        return vacantUnits;
    }
}