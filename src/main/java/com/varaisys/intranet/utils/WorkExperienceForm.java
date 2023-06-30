package com.varaisys.intranet.utils;

public class WorkExperienceForm {
    WorkExperienceForm() {
    }

    public int id;
    public String companyName;
    public String jobTitle;
    public String fromDate;
    public String toDate;
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

    @Override
    public String toString() {
        return "WorkExperienceForm  [id=" + id + ",companyName=" + companyName + ",jobTitle=" + jobTitle
                + ",fromDate=" + fromDate + ",toDate=" + toDate + ", comment="
                + comment + "]";
    }

}

