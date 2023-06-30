package com.varaisys.intranet.utils;

public class SkillsForm {
    SkillsForm(){}
    public int id;
    public String skills;
    public String yearOfexperience;
    public String comment;

    public int getid(){
        return id;
    }
    public void setid(int id){
        this.id=id;
    }
    public String getskills(){
        return skills;
    }
    public void setskills(String skills){
        this.skills=skills;
    }
    public String getyearOfexperience(){
        return yearOfexperience;
    }
    public void setyearOfexperience(String yearOfexperience){
        this.yearOfexperience=yearOfexperience;
    }
    public String getcomment(){
        return comment;
    }
    public void setcomment(String comment){
        this.comment=comment;
    } 
}

