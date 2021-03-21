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


    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getAddress() {
        return Address;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public String getCity() {
        return City;
    }

    public void setState(String state) {
        this.State = state;
    }

    public String getState() {
        return State;
    }

    public void setZip(String zip) {
        this.Zip = zip;
    }

    public String getZip() {
        return Zip;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getEmail() {
        return Email;
    }

}
