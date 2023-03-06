package org.example.model;

import org.example.builders.TenantBuilder;

public class Tenant implements LeaseSubscriber {
    private String fullName;
    private String phoneNumber;
    private String email;
    private int rentedUnitId;
    private double monthlyRent;
    private boolean isRentPaid;

    private int tenantId;

    private static int _id = 121;

    public Tenant(TenantBuilder tenantBuilder) {
        this.fullName = tenantBuilder.getFullName();
        this.phoneNumber = tenantBuilder.getPhoneNumber();
        this.email = tenantBuilder.getEmail();
        this.tenantId = _id;
        _id++;
    }

    public void updateTenant(Unit unit){
        System.out.println(unit+"\n"+"This property is available for rent.");
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRentedUnitId() {
        return rentedUnitId;
    }

    public void setRentedUnitId(int rentedUnitId) {
        this.rentedUnitId = rentedUnitId;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public boolean isRentPaid() {
        return isRentPaid;
    }

    public void setRentPaid(boolean rentPaid) {
        isRentPaid = rentPaid;
    }

    @Override
    public String toString() {
        return  "FullName: " + fullName + '\n' +
                "PhoneNumber: " + phoneNumber + '\n' +
                "Email: " + email + '\n' +
                "Monthly Rent: " + monthlyRent;
    }
}
