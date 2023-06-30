package com.varaisys.intranet.daoImpl;
import com.varaisys.intranet.model.languagesDetails;
import com.varaisys.intranet.dao.LanguagesDao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.varaisys.intranet.dao.AbstractDao;

@Repository
@Transactional
public class LanguagesDaoImpl extends AbstractDao<Integer,languagesDetails> implements LanguagesDao{
    @Override
    public boolean Addlanguages(languagesDetails details) {
        persist(details);
        return true;
    }
    @Override
    public List<languagesDetails>getlanguages() {

        return createEntityCriteria().list();
    }
    
}

