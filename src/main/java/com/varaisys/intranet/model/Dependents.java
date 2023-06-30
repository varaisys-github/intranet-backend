package com.varaisys.intranet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import net.bytebuddy.asm.Advice.Return;

/**
 * 
 * @author Kanishka Rajput
 * @Created on 6/feb/2023
 */
@Entity
@Table(name = "dependents")
public class Dependents implements Serializable {
    @Id
    @Column(name = "id")
    public int Id;
    @Column(name = "name")
    public String Name;
    @Column(name = "relationship")
    public String Relationship;
    @Column(name = "dob")
    public String DOB;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getRelationship() {
        return Relationship;
    }

    public void setRelationship(String Relationship) {
        this.Relationship = Relationship;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

}

