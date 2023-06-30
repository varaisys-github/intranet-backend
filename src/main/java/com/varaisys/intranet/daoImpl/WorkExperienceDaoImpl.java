package com.varaisys.intranet.daoImpl;

import com.varaisys.intranet.dao.AbstractDao;
import com.varaisys.intranet.model.WorkExperience;
import com.varaisys.intranet.dao.WorkExperienceDao;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kanishka Rajput
 * @Created on 15/feb/2023
 */

@Repository
@Transactional

public class WorkExperienceDaoImpl extends AbstractDao<Integer, WorkExperience> implements WorkExperienceDao {
    @Override
    public void Addexperience(WorkExperience detail) {
        System.out.println("kanishka....>>");
        System.out.println(detail);
        persist(detail);
        // return true;
    }

    @Override
    public List<WorkExperience> getExperience() {

        return createEntityCriteria().list();
    }

    @Override
    public WorkExperience getExperienceById(int id) {
        WorkExperience workexperience = getByKey(id);
        return workexperience;
    }

}
