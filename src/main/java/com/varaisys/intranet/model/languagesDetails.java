package com.varaisys.intranet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * 
 * @author Kanishka Rajput
 * @Created on 16/march/2023
 */
@Entity
@Table(name = "languages")
public class languagesDetails implements Serializable{
    @Id
    @Column(name = "id")
    public int id;
    @Column(name = "language")
    public String language;
    @Column(name = "fulency")
    public String fulency;
    @Column(name = "competency")
    public String competency;
    @Column(name = "comment")
    public String comment;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getlanguage() {
        return language;
    }

    public void setlanguage(String language) {
        this.language = language;
    }

    public String getfulency() {
        return fulency;
    }

    public void setfulency(String fulency) {
        this.fulency = fulency;
    }

    public String getcompetency() {
        return competency;
    }

    public void setcompetency(String competency) {
        this.competency = competency;
    }
    public String getcomment(){
        return comment;
    }
    public void setcomment(String comment){
        this.comment=comment;
    }

}

