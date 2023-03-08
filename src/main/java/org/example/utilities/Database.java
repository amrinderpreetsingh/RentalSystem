package org.example.utilities;

import org.example.builders.ApartmentBuilder;
import org.example.builders.HouseBuilder;
import org.example.builders.LeaseBuilder;
import org.example.builders.TenantBuilder;
import org.example.model.Apartment;
import org.example.model.Lease;
import org.example.model.Tenant;
import org.example.model.Unit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Database {
    private static Database db;

    private ArrayList<Unit> properties;
    private ArrayList<Tenant> tenants;
    private ArrayList<Lease> leases;

    private Database() {
        properties = new ArrayList<Unit>();
        tenants = new ArrayList<Tenant>();
        leases = new ArrayList<Lease>();
        getData();
    }

    public static Database getInstance() {
        if (db == null) {
            db = new Database();
        }
        return db;
    }

    public void addProperty(Unit unit) {
        properties.add(unit);
    }

    public void addTenant(Tenant tenant) {
        tenants.add(tenant);
    }

    public void addLease(Lease lease) {
        leases.add(lease);
    }

    public ArrayList<Unit> getProperties() {
        return properties;
    }

    public ArrayList<Tenant> getTenants() {
        return tenants;
    }

    public ArrayList<Lease> getLeases() {
        return leases;
    }

    private void getData() {
        Unit house1 = new HouseBuilder("Sherbrooke", "Montreal", "H4B1P5", false, "7", 2000).build();
        Unit house2 = new HouseBuilder("Monkland", "Montreal", "H4B1P5", false, "88", 1200).build();
        Unit apartment1 = new ApartmentBuilder("Rue Maher", "Asr", "143001", true, "7", 1400, 3, 1, 150, "2").build();
        apartment1.setIsRented(true);

        properties.add(house1);
        properties.add(house2);
        properties.add(apartment1);

        Tenant tenant1 = new TenantBuilder("Sunny", "998822", "sunny@gmail.com").build();
        Tenant tenant2 = new TenantBuilder("Gagan", "798822", "gagan@gmail.com").build();
        tenants.add(tenant1);
        tenants.add(tenant2);
        tenant1.setRentedUnitId(apartment1.getUnitId());
        tenant1.setMonthlyRent(apartment1.getMonthlyRent());
        Lease lease1 = new LeaseBuilder(apartment1, tenant1, new Date(2021, 2, 5), new Date(2023, 2, 7)).build();
        leases.add(lease1);
    }
}
