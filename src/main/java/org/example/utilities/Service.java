package org.example.utilities;

import org.example.builders.LeaseBuilder;
import org.example.builders.TenantBuilder;
import org.example.builders.UnitBuilder;
import org.example.model.*;

import java.util.ArrayList;

public class Service {
    Database db;

    public Service() {
        db = Database.getInstance();
    }

    public ArrayList<Unit> getProperties() {
        return db.getProperties();
    }

    public ArrayList<Tenant> getTenants() {
        return db.getTenants();
    }

    public void addProperty(UnitBuilder builder) {
        Unit unit = builder.build();
        db.addProperty(unit);
    }

    public void addTenant(TenantBuilder builder) {
        Tenant tenant = builder.build();
        db.addTenant(tenant);
    }

    public ArrayList<Unit> getPropertiesByType(String type) {
        ArrayList<Unit> propertiesOfOneType = new ArrayList<>();
        for (Unit property : db.getProperties()) {
            if (property.getClass().getSimpleName().equalsIgnoreCase(type)) {
                propertiesOfOneType.add(property);
            }
        }
        return propertiesOfOneType;
    }

    public Unit getPropertyById(int id) {
        for (Unit property : db.getProperties()) {
            if (property.getUnitId() == id) {
                return property;
            }
        }
        return null;
    }

    public Tenant getTenantByEmail(String email) {
        for (Tenant tenant : db.getTenants()) {
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
        Lease lease = builder.build();
        db.addLease(lease);
    }

    public ArrayList<Lease> getAllLeases() {
        return db.getLeases();
    }

    public ArrayList<Unit> getRentedUnits() {
        ArrayList<Unit> rentedUnits = new ArrayList<>();
        for (Unit unit : db.getProperties()) {
            if (unit.getIsRented()) {
                rentedUnits.add(unit);
            }
        }
        return rentedUnits;
    }

    public ArrayList<Unit> getVacantUnits() {
        ArrayList<Unit> vacantUnits = new ArrayList<>();
        for (Unit unit : db.getProperties()) {
            if (!unit.getIsRented()) {
                vacantUnits.add(unit);
            }
        }
        return vacantUnits;
    }

    public void subscribeToUnit(Unit unit, Tenant tenant) {
        Lease lease = null;
        ArrayList<Lease> leases = db.getLeases();
        for (Lease l :
                leases) {
            if (l.getProperty().getUnitId() == unit.getUnitId()) {
                lease = l;
            }
        }
        lease.addSubscriber(tenant);
        lease.notifySubscriber();
    }
}