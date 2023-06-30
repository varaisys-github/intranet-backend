package com.varaisys.intranet.utils;

public class LanguagesForm {
    LanguagesForm(){}
    private int id;
    private String language;
    private String fulency;
    private String competency;
    private String comment;
    
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

