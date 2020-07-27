package com.rishabh.companyproject.Database;

public class UserHelperClass {
    String fullName, phoneNo, email, pinCode, address;

    public UserHelperClass() {
    }

    public UserHelperClass(String fullName, String phoneNo, String email, String pinCode, String address) {
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.pinCode = pinCode;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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
}
