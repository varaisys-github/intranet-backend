package com.varaisys.intranet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Kanishka Rajput
 * @Created on 15/feb/2023
 */

@Entity
@Table(name = "work_experience")
public class WorkExperience implements Serializable {
    @Id
    @Column(name = "id")
    public int id;
    @Column(name = "company_name")
    public String companyName;
    @Column(name = "job_title")
    public String jobTitle;
    @Column(name = "from_date")
    public String fromDate;
    @Column(name = "to_date")
    public String toDate;
    @Column(name = "comment")
    public String comment;

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getcompanyName() {
        return companyName;
    }

    public void setcompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getjobTitle() {
        return jobTitle;
    }

    public void setjobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getfromDate() {
        return fromDate;
    }

    public void setfromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String gettoDate() {
        return toDate;
    }

    public void settoDate(String toDate) {
        this.toDate = toDate;
    }

    public String getcomment() {
        return comment;
    }

    public void setcomment(String comment) {
        this.comment = comment;
    }

}
