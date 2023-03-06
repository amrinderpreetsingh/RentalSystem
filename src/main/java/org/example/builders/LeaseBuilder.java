package org.example.builders;

import org.example.model.Lease;
import org.example.model.Tenant;
import org.example.model.Unit;

import java.util.Date;

public class LeaseBuilder {
    private Unit unit;
    private Tenant tenant;
    private double monthlyRent;
    private Date startDate;
    private Date endDate;

    public LeaseBuilder(Unit unit, Tenant tenant, Date startDate, Date endDate) {
        this.unit = unit;
        this.tenant = tenant;
        this.monthlyRent = unit.getMonthlyRent();
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Lease build(){
        return new Lease(this);
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
