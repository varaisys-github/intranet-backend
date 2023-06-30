package com.varaisys.intranet.dao;

import com.varaisys.intranet.model.WorkExperience;
import java.util.List;

/**
 * 
 * @author Kanishka Rajput
 * @Created on 15/feb/2023
 */

public interface WorkExperienceDao {
    public void Addexperience(WorkExperience detail);

    public List<WorkExperience> getExperience();

    public WorkExperience getExperienceById(int id);

}

