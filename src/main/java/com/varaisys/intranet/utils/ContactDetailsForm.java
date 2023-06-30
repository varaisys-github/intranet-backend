package com.varaisys.intranet.utils;

public class ContactDetailsForm {
    ContactDetailsForm() {
    }

    private int id;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private int zipCode;
    private String country;
    private String home;
    private String mobile;
    private String work;
    private String workEmail;
    private String otherEmail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getMobile() {
        return mobile;
    }

    public void setmobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWork() {
        return work;
    }

    public void setwork(String work) {
        this.work = work;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getOtherEmail() {
        return otherEmail;
    }

    public void setOtherEmail(String otherEmail) {
        this.otherEmail = otherEmail;
    }

    @Override
    public String toString() {
        return "ContactDetailsForm [id=" + id + ",street1=" + street1 + ", street2 =" + street2 + ",city=" + city
                + ",state=" + state + ",zipCode=" + zipCode + ",country=" + country + ",home=" + home + ",mobile="
                + mobile + ",work=" + work + ",workEmail=" + workEmail + ",otherEmail=" + otherEmail + "]";
    }

}
