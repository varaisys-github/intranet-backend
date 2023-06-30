package com.varaisys.intranet.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.varaisys.intranet.service.WorkExperienceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.varaisys.intranet.dao.WorkExperienceDao;
import com.varaisys.intranet.utils.WorkExperienceForm;
import com.varaisys.intranet.globalExceptionHandling.PersonNotFoundException;
import com.varaisys.intranet.model.WorkExperience;

@Service()
@Transactional("mydb")

public class WorkExperienceServiceImpl implements WorkExperienceService {
    private boolean flag = false;
    @Autowired
    WorkExperienceDao workexperienceDao;

    @Override
    public boolean AddExperience(WorkExperienceForm workexperienceForm) throws PersonNotFoundException {
        WorkExperience workexperience = new WorkExperience();
        // workexperience.setid(workexperienceForm.getid());
        workexperience.setcompanyName(workexperienceForm.getcompanyName());
        workexperience.setjobTitle(workexperienceForm.getjobTitle());
        workexperience.setfromDate(workexperienceForm.getfromDate());
        workexperience.settoDate(workexperienceForm.gettoDate());
        workexperience.setcomment(workexperienceForm.getcomment());
        workexperienceDao.Addexperience(workexperience);

        System.out.println("DEtails : " + flag + "....>>>>.kanishkaaa");
        return flag;

    }

    @Override
    public List<WorkExperience> getallExperience() {

        return workexperienceDao.getExperience();
    }

    @Override
    public WorkExperience getExperience(int id) {
        WorkExperience emergencyContact = workexperienceDao.getExperienceById(id);
        return emergencyContact;
    }

}

