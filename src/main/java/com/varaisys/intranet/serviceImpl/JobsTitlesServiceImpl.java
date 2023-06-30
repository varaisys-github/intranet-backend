package com.varaisys.intranet.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varaisys.intranet.dao.JobTitlesDao;
import com.varaisys.intranet.model.JobsTitles;
import com.varaisys.intranet.service.JobsTitlesService;
import com.varaisys.intranet.utils.JobsTitlesForm;
/**
 * 
 * @author Sachin Kashyap 
 * @Created On 11-nov-2022
 *@Created on 14-nov-20222
 */
@Service()  
@Transactional("mydb")
public class JobsTitlesServiceImpl implements JobsTitlesService{
@Autowired
JobTitlesDao jobTitlesDao ;
	@Override
	public void saveJobsTitles(JobsTitlesForm form) {
		JobsTitles jobTitles = new JobsTitles();
		jobTitles.setJobTitle(form.getJobTitle());
		jobTitles.setJobDescription(form.getJobDescription());
		jobTitles.setNote(form.getNote());
		jobTitles.setStatus(form.getStatus());
		jobTitlesDao.saveJobTitles(jobTitles);
	}

	@Override
	public List<JobsTitles> getAllJobTitles() {
		List<JobsTitles> jobTitles = jobTitlesDao.getAllTitles();
		return jobTitles;
	}

}
