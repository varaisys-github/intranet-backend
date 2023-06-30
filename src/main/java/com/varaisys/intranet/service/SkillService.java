package com.varaisys.intranet.service;
import com.varaisys.intranet.utils.SkillsForm;
import java.util.List;
import com.varaisys.intranet.model.SkillsDetails;

public interface SkillService {
    public boolean Addskills(SkillsForm skillsForm);
    public List<SkillsDetails>getskills();
}

