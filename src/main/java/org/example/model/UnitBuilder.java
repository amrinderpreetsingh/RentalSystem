package org.example.model;

public abstract class UnitBuilder {
    private String streetName;
    private String city;
    private String postalCode;
    private boolean isRented;
    private String streetNumber;

    public UnitBuilder(String streetName, String city, String postalCode, boolean isRented, String streetNumber) {
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.isRented = isRented;
        this.streetNumber = streetNumber;
    }
    public abstract Unit build();

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }
}
