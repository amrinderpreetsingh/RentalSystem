package org.example;

public class UnitView {
    public String streetName;
    public String city;
    public String postalCode;
    public boolean isRented;



    public String streetNumber;
    public int unitId;
    public UnitView(String streetName, String city, String postalCode, boolean isRented, String streetNumber) {
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.isRented = isRented;
        this.streetNumber = streetNumber;
    }
}
