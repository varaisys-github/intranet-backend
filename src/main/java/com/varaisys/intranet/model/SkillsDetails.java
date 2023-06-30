package com.varaisys.intranet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Kanishka Rajput
 * @Created on 20/march/2023
 */
@Entity
@Table(name="skills")

public class SkillsDetails implements Serializable{
    @Id
    @Column(name="id")
    public int id;
    @Column(name="skills")
    public String skills;
    @Column(name="yearOfexperience")
    public String yearOfexperience;
    @Column(name="comment")
    public String comment;  

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getskills(){
        return skills;
    }
    public void setskills(String skills){
        this.skills =skills;
    }
    public String getyearofexperience(){
        return yearOfexperience;
    }
    public void setyearofexperience(String yearOfexperience){
        this.yearOfexperience=yearOfexperience;
    }
    public String getcomment(){
        return comment;
    }
    public void setcomment(String comment){
        this.comment=comment;
    }

}
