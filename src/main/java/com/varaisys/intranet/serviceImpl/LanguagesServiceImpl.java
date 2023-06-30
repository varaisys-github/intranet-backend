package com.varaisys.intranet.serviceImpl;
import com.varaisys.intranet.dao.LanguagesDao;
import com.varaisys.intranet.globalExceptionHandling.PersonNotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.varaisys.intranet.utils.LanguagesForm;
import com.varaisys.intranet.model.languagesDetails;
import com.varaisys.intranet.service.LanguagesService;

@Service
@Transactional("mydb")

public class LanguagesServiceImpl implements LanguagesService {



    private boolean flag = false;
    @Autowired
    LanguagesDao languagesDao;

    @Override
    public boolean Addlanguages(LanguagesForm languagesForm) throws PersonNotFoundException {
      
        languagesDetails languagesDetails = new languagesDetails();
        languagesDetails.setlanguage(languagesForm.getlanguage());
        languagesDetails.setfulency(languagesForm.getfulency());
        languagesDetails.setcompetency(languagesForm.getcompetency());
        languagesDetails.setcomment(languagesForm.getcomment());
        
        languagesDao.Addlanguages(languagesDetails);
        return flag;

    }

    @Override
    public List<languagesDetails> getlanguages() {

        return languagesDao.getlanguages();
    }
    
}

