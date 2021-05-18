package com.rishabh.companyproject.Database;


import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class UserDetails {

    private String fullName;
    private String email;
    private String pinCode;
    private String address;
    private String phoneNo;

    public UserDetails() {
    }

    public UserDetails(String fullName, String email, String pinCode, String address, String phoneNo) {
        this.fullName = fullName;
        this.email = email;
        this.pinCode = pinCode;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
