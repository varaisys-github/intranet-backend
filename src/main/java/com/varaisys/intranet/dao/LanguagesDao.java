package com.varaisys.intranet.dao;
import com.varaisys.intranet.model.languagesDetails;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface LanguagesDao {

    public boolean Addlanguages(languagesDetails details);

    public List<languagesDetails> getlanguages();    
    
}

