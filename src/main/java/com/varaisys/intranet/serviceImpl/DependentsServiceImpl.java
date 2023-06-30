package com.varaisys.intranet.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varaisys.intranet.dao.DependentsDao;
import com.varaisys.intranet.globalExceptionHandling.PersonNotFoundException;
import com.varaisys.intranet.model.Dependents;
import com.varaisys.intranet.service.DependentsService;
import com.varaisys.intranet.utils.DependentsForm;
import java.util.List;

@Service
@Transactional("mydb")

public class DependentsServiceImpl implements DependentsService {
    private boolean flag = false;
    @Autowired
    DependentsDao dependentsDao;

    @Override
    public boolean AddDependents(DependentsForm dependentsForm) throws PersonNotFoundException {
        Dependents dependents = new Dependents();
        dependents.setName(dependentsForm.getName());
        dependents.setRelationship(dependentsForm.getRelationship());
        dependents.setDOB(dependentsForm.getDOB());
        dependentsDao.AddDependents(dependents);
        return flag;

    }

    @Override
    public List<Dependents> getDependents() {

        return dependentsDao.getAllDependents();
    }

}

