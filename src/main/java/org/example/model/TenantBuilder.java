package org.example.model;

public class TenantBuilder {
    private String fullName;
    private String phoneNumber;
    private String email;

    public TenantBuilder(String fullName, String phoneNumber, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Tenant build() {
        return new Tenant(this);
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

}
