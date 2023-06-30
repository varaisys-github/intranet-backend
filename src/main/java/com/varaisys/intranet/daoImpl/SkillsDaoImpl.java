package com.varaisys.intranet.daoImpl;

import org.springframework.security.access.vote.AbstractAccessDecisionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.varaisys.intranet.model.SkillsDetails;
import com.varaisys.intranet.dao.SkillsDao;
import com.varaisys.intranet.dao.AbstractDao;
import java.util.List;
@Repository
@Transactional

public class SkillsDaoImpl extends AbstractDao<Integer,SkillsDetails> implements SkillsDao {
    @Override
    public boolean Addskills(SkillsDetails details) {
        System.out.println("kanishka....>>");
        System.out.println(details);
        persist(details);
         return true;
    }
    @Override
    public List<SkillsDetails> getskills() {

        return createEntityCriteria().list();
    }

    
}

