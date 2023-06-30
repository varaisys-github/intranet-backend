package com.varaisys.intranet.utils;

public class EmergencyContactForm {
    EmergencyContactForm() {
    }

    public int id;
    public String EmergencyName;
    public String Relationship;
    public String EmergencyMobile;
    public String WorkTelephone;
    public String HomeTelephone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmergencyName() {
        return EmergencyName;
    }

    public void setEmergencyName(String EmergencyName) {
        this.EmergencyName = EmergencyName;
    }

    public String getRelationship() {
        return Relationship;
    }

    public void setRelationship(String Relationship) {
        this.Relationship = Relationship;
    }

    public String getEmergencyMobile() {
        return EmergencyMobile;
    }

    public void setEmergencyMobile(String EmergencyMobile) {
        this.EmergencyMobile = EmergencyMobile;
    }

    public String getWorkTelephone() {
        return WorkTelephone;
    }

    public void setWorkTelephone(String WorkTelephone) {
        this.WorkTelephone = WorkTelephone;
    }

    public String getHomeTelephone() {
        return HomeTelephone;
    }

    public void setHomeTeelephone(String HomeTelephone) {
        this.HomeTelephone = HomeTelephone;
    }

    @Override
    public String toString() {
        return "EmergencyContactForm [id=" + id + ",EmergencyName=" + EmergencyName + ",Relationship=" + Relationship
                + ",EmergencyMobile=" + EmergencyMobile + ",WorkTelephone=" + WorkTelephone + ", HomeTelephone="
                + HomeTelephone + "]";
    }

}

