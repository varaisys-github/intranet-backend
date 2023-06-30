package com.varaisys.intranet.daoImpl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.varaisys.intranet.dao.AbstractDao;
import com.varaisys.intranet.dao.JobTitlesDao;
import com.varaisys.intranet.model.JobsTitles;
/**
 * 
 * @author Sachin Kashyap
 * @Created on 11-nov-2022
 * @modify on 14-nov-2022
 */
@Repository
public class JobTitlesDaoImpl extends AbstractDao<Long, JobsTitles> implements JobTitlesDao {

	@Override
	public void saveJobTitles(JobsTitles jobsTitles) {
		 persist(jobsTitles);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JobsTitles> getAllTitles() {
		
		return createEntityCriteria().list();
	}

	@Override
	public JobsTitles getTitlesById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobsTitles getTitlesByJobTitles(String jobTitles) {
		
		return null;
	}

}
