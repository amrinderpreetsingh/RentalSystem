package org.example.controller;

import org.example.builders.TenantBuilder;
import org.example.builders.UnitBuilder;
import org.example.model.Lease;
import org.example.model.Tenant;
import org.example.model.Unit;
import org.example.utilities.Service;

import java.util.ArrayList;

public class RentalController implements Controller {

    Service service = new Service();

    @Override
    public void addProperty(UnitBuilder unitBuilder) {
        service.addProperty(unitBuilder);
    }

    public void addTenant(TenantBuilder tenantBuilder) {
        service.addTenant(tenantBuilder);
    }

    public ArrayList<Unit> getAllProperties() {
        return service.getAllProperties();
    }

    public ArrayList<Unit> getPropertiesByType(String type) {
        return service.getPropertiesByType(type);
    }

    public Unit getPropertyById(int id) {
        return service.getPropertyById(id);
    }

    public Tenant getTenantByEmail(String email) {
        return service.getTenantByEmail(email);
    }

    public void addLease(LeaseBuilder leaseBuilder){
        service.addLease(leaseBuilder);
    }

    public ArrayList<Lease>getLeases(){
        return service.getAllLeases();
    }

    public ArrayList<Unit> getProperties(){
        properties =service.getProperties();
        return properties;
    }

    public ArrayList<Tenant> getTenants(){
        tenants=service.getTenants();
        return tenants;
    }

    public ArrayList<Unit> displayRented(){
        properties =service.getProperties();
        ArrayList<Unit> rented = new ArrayList<>();
        for (Unit unit:properties) {
            if(unit.isRented()){
                rented.add(unit);
            }
        }
        return rented;
    }

    public ArrayList<Unit> displayVacant(){
        properties =service.getProperties();
        ArrayList<Unit> isVacant = new ArrayList<>();
        for (Unit unit:properties) {
            if(!unit.isRented()){
                isVacant.add(unit);
            }
        }
        return isVacant;
    }
}
