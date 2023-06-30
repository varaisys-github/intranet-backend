package com.varaisys.intranet.service;
import com.varaisys.intranet.utils.LanguagesForm;

import java.util.List;

import com.varaisys.intranet.model.languagesDetails;

public interface LanguagesService {
    public boolean Addlanguages(LanguagesForm languagesForm);

    public List<languagesDetails>getlanguages();

    
}

