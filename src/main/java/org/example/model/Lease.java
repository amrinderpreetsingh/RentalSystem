package org.example.model;

import org.example.builders.LeaseBuilder;
import org.example.utilities.Constant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Lease implements LeaseObserverable {
    private Unit property;
    private Tenant tenant;
    private double monthlyRent;
    private Date startDate;
    private Date endDate;
    private int leaseId;
    private static int _id = 300;
    private ArrayList<Tenant> subscribers;

    public Lease(LeaseBuilder leaseBuilder) {
        property = leaseBuilder.getUnit();
        tenant = leaseBuilder.getTenant();
        monthlyRent = leaseBuilder.getUnit().getMonthlyRent();
        startDate = leaseBuilder.getStartDate();
        endDate = leaseBuilder.getEndDate();
        leaseId = _id;
        _id++;
        subscribers = new ArrayList<>();
    }

    public int getLeaseId() {
        return leaseId;
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.DATE_FORMAT);
        return "Unit Details:\n" + this.getProperty() + "\n" +
                "Tenant Details:" + this.getTenant() + "\n" +
                "Star Date: " + simpleDateFormat.format(this.getStartDate()) + "\n" +
                "End Date: " + simpleDateFormat.format(this.getEndDate());
    }

    @Override
    public void addSubscriber(Tenant tenant) {
        subscribers.add(tenant);
    }

    @Override
    public void unSubscribe(Tenant tenant) {
        subscribers.remove(tenant);
    }

    @Override
    public void notifySubscriber() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constant.DATE_FORMAT);
        if (simpleDateFormat.format(this.getEndDate()).equalsIgnoreCase(String.valueOf(java.time.LocalDate.now()))) {
            for (Tenant sub :
                    subscribers) {
                sub.updateTenant(property);
                unSubscribe(sub);
            }
        }
    }
}
