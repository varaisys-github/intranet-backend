package com.varaisys.intranet.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.varaisys.intranet.model.SkillsDetails;
@Repository

public interface SkillsDao {
    public boolean Addskills(SkillsDetails details);
    public List<SkillsDetails> getskills();  
}
