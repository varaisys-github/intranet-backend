package com.varaisys.intranet.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.varaisys.intranet.dao.SkillsDao;
import com.varaisys.intranet.globalExceptionHandling.PersonNotFoundException;

import com.varaisys.intranet.utils.SkillsForm;
import com.varaisys.intranet.model.SkillsDetails;
import java.util.List;
import com.varaisys.intranet.service.SkillService;

@Service
@Transactional("mydb")


public class SkillServiceImpl implements SkillService{
    private boolean flag = false;
    @Autowired
    SkillsDao skillsDao;
    @Override
    public boolean Addskills(SkillsForm skillsForm) throws PersonNotFoundException {
        SkillsDetails skillsDetails =new SkillsDetails();
        skillsDetails.setskills(skillsForm.getskills());
        skillsDetails.setyearofexperience(skillsForm.getyearOfexperience());
        skillsDetails.setcomment(skillsForm.getcomment());
        skillsDao.Addskills(skillsDetails);
        return flag;
    }
    @Override
    public List< SkillsDetails> getskills() {
        return skillsDao.getskills();
    } 
}
