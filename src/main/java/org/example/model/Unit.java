package org.example.model;

public abstract class Unit {
    private String streetName;
    private String city;
    private String postalCode;
    private boolean isRented;
    private String streetNumber;

    private int unitId;
    private static int _unitId=101;


    public Unit(UnitBuilder unitBuilder){
        this.streetName = unitBuilder.getStreetName();
        this.city = unitBuilder.getCity();
        this.postalCode = unitBuilder.getPostalCode();
        this.isRented = unitBuilder.isRented();
        this.streetNumber = unitBuilder.getStreetNumber();
        this.unitId=_unitId;
        _unitId++;
    }

    public int getUnitId() {
        return unitId;
    }


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
