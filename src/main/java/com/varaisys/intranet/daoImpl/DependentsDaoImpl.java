package com.varaisys.intranet.daoImpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.varaisys.intranet.dao.AbstractDao;
import com.varaisys.intranet.dao.DependentsDao;
import com.varaisys.intranet.model.Dependents;
import java.util.List;

/**
 *
 * @author Kanishka Rajput
 * @Created on 6/feb/2023
 */
@Repository
@Transactional
public class DependentsDaoImpl extends AbstractDao<Integer, Dependents> implements DependentsDao {
    @Override
    public boolean AddDependents(Dependents details) {
        persist(details);
        return true;
    }

    @Override
    public List<Dependents> getAllDependents() {

        return createEntityCriteria().list();
    }
}
