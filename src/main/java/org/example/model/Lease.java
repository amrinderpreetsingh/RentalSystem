package org.example.model;

import org.example.builders.LeaseBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Lease {
    private Unit property;
    private Tenant tenant;
    private double monthlyRent;
    private Date startDate;
    private Date endDate;

    public Lease(LeaseBuilder leaseBuilder) {
        property = leaseBuilder.getUnit();
        tenant = leaseBuilder.getTenant();
        monthlyRent = leaseBuilder.getUnit().getMonthlyRent();
        startDate = leaseBuilder.getStartDate();
        endDate = leaseBuilder.getEndDate();
    }

    public Unit getProperty() {
        return property;
    }

    public void setProperty(Unit property) {
        this.property = property;
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

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "Unit Details:\n" + this.getProperty().toString() + "\n" +
                "Tenant Details:" + "\n" +
                "Star Date: " + simpleDateFormat.format(this.getStartDate()) + "\n" +
                "End Date: " + simpleDateFormat.format(this.getEndDate());
    }
}
