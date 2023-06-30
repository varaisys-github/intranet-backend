package com.varaisys.intranet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Kanishka Rajput
 * @Created on 3/feb/2023
 */

@Entity
@Table(name = "emergency_contact")
public class EmergencyContact implements Serializable {
    @Id
    @Column(name = "id")
    public int id;
    @Column(name = "emergency_name")
    public String EmergencyName;
    @Column(name = "relationship")
    public String Relationship;
    @Column(name = "emergency_mobile")
    public String EmergencyMobile;
    @Column(name = "work_telephone")
    public String WorkTelephone;
    @Column(name = "home_telephone")
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

    public void setHomeTelephone(String HomeTelephone) {
        this.HomeTelephone = HomeTelephone;
    }

}
