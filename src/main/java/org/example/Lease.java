package org.example;

import java.util.Date;

public class Lease {
    private Tenant tenant;
    private Unit rentalUnit;
    private Date startDate;
    private Date endDate;
    private double rentAmount;

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Unit getRentalUnit() {
        return rentalUnit;
    }

    public void setRentalUnit(Unit rentalUnit) {
        this.rentalUnit = rentalUnit;
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

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }
}
