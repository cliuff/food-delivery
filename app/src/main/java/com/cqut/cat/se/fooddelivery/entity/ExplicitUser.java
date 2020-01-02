package com.cqut.cat.se.fooddelivery.entity;

/**
 * Consumer and Businessman instead of Administrator
 */
public class ExplicitUser extends User {
    private String realName;
    private String address;
    private String phoneNumber;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
