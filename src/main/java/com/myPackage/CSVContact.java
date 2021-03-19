package com.myPackage;

import com.opencsv.bean.CsvBindByName;

public class CSVContact {

    @CsvBindByName
    private String FirstName;

    @CsvBindByName
    private String LastName;

    @CsvBindByName(column="Address")
    private String Address;

    @CsvBindByName(column="City")
    private String City;

    @CsvBindByName(column="State")
    private String State;

    @CsvBindByName(column="ZipCode")
    private String Zip;

    @CsvBindByName(column="PhoneNumber")
    private String PhoneNumber;

    @CsvBindByName(column="Email")
    private String Email;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String zip) {
        Zip = zip;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
