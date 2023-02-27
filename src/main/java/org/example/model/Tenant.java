package org.example.model;

public class Tenant {
    private String fullName;
    private String phoneNumber;
    private String email;
    private int rentedUnitId;
    private int monthlyRent;
    private boolean isRentPaid;

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

    public int getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(int monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public boolean isRentPaid() {
        return isRentPaid;
    }

    public void setRentPaid(boolean rentPaid) {
        isRentPaid = rentPaid;
    }
}
