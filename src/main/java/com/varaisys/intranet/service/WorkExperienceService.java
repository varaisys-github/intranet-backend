package com.varaisys.intranet.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.varaisys.intranet.model.WorkExperience;
import com.varaisys.intranet.utils.WorkExperienceForm;

@Service

public interface WorkExperienceService {
    public List<WorkExperience> getallExperience();

    public WorkExperience getExperience(int Id);

    public boolean AddExperience(WorkExperienceForm workexperienceForm);

}
